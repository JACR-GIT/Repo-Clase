import csv
import datetime
import json

from django.contrib.admin.views.decorators import staff_member_required
from django.contrib.auth import login, authenticate, logout
from django.contrib.auth.decorators import login_required
from django.db import connections
from django.http import JsonResponse
from django.shortcuts import render, redirect, get_object_or_404
from django.views.decorators.http import require_POST

from rankingApp.forms import LoginForm, RegisterForm
from rankingApp.models import Album, Category, Ranking, Review, User


def go_home(request):
    return render(request, 'albunes.html')


def show_albunes(request):
    list_albunes = Album.objects.using('mongodb').all()
    return render(request, 'albunes.html', {'list_albunes': list_albunes})


def do_login(request):
    if request.method == 'POST':
        form = LoginForm(request, data=request.POST)
        if form.is_valid():
            username = form.cleaned_data.get('username')
            password = form.cleaned_data.get('password')
            user = authenticate(request, username=username, password=password)
            if user is not None:
                login(request, user)
                return redirect('rankingApp:albunes')
    else:
        form = LoginForm()

    return render(request, 'login.html', {"form": form})


def do_register(request):
    if request.method == 'POST':
        form = RegisterForm(request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            user.set_password(form.cleaned_data['password'])
            user.save()
            return redirect('rankingApp:do_login')
        else:
            return render(request, 'register.html', {"form": form})
    else:
        form = RegisterForm()
        return render(request, 'register.html', {"form": form})


def logout_user(request):
    logout(request)
    return redirect('rankingApp:do_login')


def data_load(request):
    if request.method == "POST":
        uploaded_file = request.FILES.get('csvFile')

        if not uploaded_file:
            return render(request, 'data_load.html', {'error': 'No se seleccionó ningún archivo.'})

        decoded_file = uploaded_file.read().decode('utf-8').splitlines()
        reader = csv.DictReader(decoded_file)

        created = 0
        updated = 0
        skipped = 0

        for row in reader:
            try:
                code_val = row.get('code')
                if code_val is None or code_val == '':
                    skipped += 1
                    continue

                try:
                    code_val = int(code_val)
                except ValueError:
                    code_val = str(code_val).strip()

                obj, is_created = Album.objects.using('mongodb').update_or_create(
                    code=code_val,
                    defaults={
                        'image': row.get('image', ''),
                        'title': row.get('title', ''),
                        'numSongs': int(row.get('numSongs', 0)),
                        'artist': [a.strip() for a in row.get('artist', '').split(',') if a.strip()],
                        'release_date': row.get('release_date', ''),
                        'genres': [g.strip() for g in row.get('genres', '').split(',') if g.strip()],
                        'category': [c.strip() for c in row.get('category', '').split(',') if c.strip()],
                    }
                )

                if is_created:
                    created += 1
                else:
                    updated += 1

            except Exception as e:
                skipped += 1
                continue

        return render(request, 'data_load.html', {
            'success': f'Carga completada: {created} creados, {updated} actualizados, {skipped} saltados'
        })

    return render(request, 'data_load.html')


def show_categorias_album(request):
    categorias = Category.objects.using('mongodb').all()
    return render(request, 'show_categorias.html', {'categorias': categorias})


def show_albunes_modificar(request):
    list_albunes = Album.objects.using('mongodb').all().order_by('code')

    category_cache = {str(cat.code): cat.name for cat in Category.objects.using('mongodb').all()}

    for album in list_albunes:
        codes = []
        if isinstance(album.category, str):
            codes = [c.strip() for c in album.category.split(',') if c.strip()]
        elif isinstance(album.category, (list, tuple)):
            codes = [str(c).strip() for c in album.category if c]

        album.category_names = [
            category_cache.get(code, f"Desconocida ({code})")
            for code in codes
        ]

    return render(request, 'albunes_modificar.html', {'list_albunes': list_albunes})


@staff_member_required
def show_panel_admin(request):
    return render(request, 'panel_admin.html')


@login_required
def show_ranking(request, category_code):
    categoria = get_object_or_404(Category.objects.using('mongodb'), code=category_code)

    if request.method == 'POST':
        ranking_list_str = request.POST.get('ranking_list')
        if not ranking_list_str:
            return JsonResponse({'status': 'error', 'message': 'No se recibió ranking_list'}, status=400)

        try:
            ranking_data = json.loads(ranking_list_str)
        except json.JSONDecodeError as e:
            return JsonResponse({'status': 'error', 'message': f'JSON inválido: {str(e)}'}, status=400)

        existing = Ranking.objects.using('mongodb').filter(
            user=request.user.username,
            categoryCode=categoria.code
        )

        if existing.exists():
            existing.update(rankingData=ranking_data)
        else:
            try:
                client = connections['mongodb'].database.client
                db_name = connections['mongodb'].settings_dict['NAME']
                db = client[db_name]
                counters = db['counters']

                result = counters.find_one_and_update(
                    {'_id': 'ranking_code_seq'},
                    {'$inc': {'seq': 1}},
                    upsert=True,
                    return_document=True
                )
                new_code = result['seq']

                Ranking.objects.using('mongodb').create(
                    code=new_code,
                    user=request.user.username,
                    categoryCode=categoria.code,
                    rankingData=ranking_data
                )
            except Exception as e:
                return JsonResponse({'status': 'error', 'message': f'Error al crear ranking: {str(e)}'}, status=500)

        return JsonResponse({'status': 'success', 'message': 'Ranking guardado correctamente'})

    categoria_str = str(category_code)
    albumes = Album.objects.using('mongodb').filter(
        category__regex=r'(^|,)' + categoria_str + r'(,|$)'
    ).order_by('-numSongs')

    ranking_obj = Ranking.objects.using('mongodb').filter(
        user=request.user.username,
        categoryCode=categoria.code
    ).first()

    tiers_data = ranking_obj.rankingData if ranking_obj else {}

    return render(request, 'ranking.html', {
        'categoria': categoria,
        'albumes': albumes,
        'titulo': f"Ranking - {categoria.name}",
        'tiers': tiers_data
    })


def show_categorias_modificar(request):
    categorias_qs = Category.objects.using('mongodb').all()

    categorias = []
    for cat in categorias_qs:
        albumes_asociados = Album.objects.using('mongodb').filter(
            category__contains=str(cat.code)
        )
        categorias.append({
            'id': str(cat.pk),
            'codigo': cat.code,
            'nombre': cat.name,
            'descripcion': getattr(cat, 'description', ''),
            'albumes_asociados': albumes_asociados
        })

    return render(request, 'categorias_modificar.html', {'categorias': categorias})


@require_POST
@login_required
def editar_categoria_ajax(request):
    try:
        code = request.POST.get('category_code')
        if not code:
            return JsonResponse({'status': 'error', 'message': 'No se recibió el código'}, status=400)

        updated = Category.objects.using('mongodb').filter(code=code).update(
            name=request.POST.get('name', ''),
            description=request.POST.get('description', ''),
            logo=request.POST.get('logo', '')
        )

        if updated > 0:
            return JsonResponse({'status': 'success', 'message': 'Categoría actualizada correctamente'})
        return JsonResponse({'status': 'error', 'message': 'La categoría no existe'}, status=404)

    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)}, status=500)


@require_POST
@login_required
def eliminar_categoria_ajax(request):
    try:
        data = json.loads(request.body)
        code = data.get('categoria_code')
        if not code:
            return JsonResponse({'status': 'error', 'message': 'No se recibió el código'}, status=400)

        deleted = Category.objects.using('mongodb').filter(code=code).delete()

        if deleted[0] > 0:
            return JsonResponse({'status': 'success', 'message': 'Categoría eliminada correctamente'})
        return JsonResponse({'status': 'error', 'message': 'La categoría no existe'}, status=404)

    except json.JSONDecodeError:
        return JsonResponse({'status': 'error', 'message': 'JSON inválido'}, status=400)
    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)}, status=500)


@login_required
def show_review(request, album_id):
    album = get_object_or_404(Album.objects.using('mongodb'), code=album_id)
    error = None

    if request.method == 'POST':
        rating = request.POST.get('rating')
        # Cambiamos 'texto' para que acepte vacíos sin error
        texto = request.POST.get('review', '').strip()

        try:
            rating = int(rating)
            if not 0 <= rating <= 5: # Permitimos desde 0 si quieres
                raise ValueError("Puntuación fuera de rango")
        except (ValueError, TypeError):
            error = 'La puntuación debe ser un número entre 0 y 5'

        if not error:
            # Tu lógica de borrar review anterior si existe se mantiene igual
            existing = Review.objects.using('mongodb').filter(
                codeAlbum=album.code,
                user=request.user.username
            )
            if existing.exists():
                existing.delete()

            Review.objects.using('mongodb').create(
                codeAlbum=album.code,
                user=request.user.username,
                rating=rating,
                review=texto,
                reviewDate=datetime.timezone.utc
            )
            return redirect('rankingApp:review', album_id=album_id)

    reviews = Review.objects.using('mongodb').filter(codeAlbum=album.code).order_by('-reviewDate')

    return render(request, 'review.html', {
        'album': album,
        'reviews': reviews,
        'error': error,
    })

@staff_member_required
def show_gestionar_usuarios(request):
    list_usuarios = User.objects.all()
    return render(request, 'gestionar_usuarios.html', {'list_usuarios': list_usuarios})


@require_POST
@login_required
def editar_album_ajax(request):
    try:
        code = request.POST.get('album_code')
        if not code:
            return JsonResponse({'status': 'error', 'message': 'No se recibió el código'}, status=400)

        updated = Album.objects.using('mongodb').filter(code=code).update(
            title=request.POST.get('title', ''),
            artist=[a.strip() for a in request.POST.get('artist', '').split(',') if a.strip()],
            release_date=request.POST.get('release_date', ''),
            numSongs=int(request.POST.get('numSongs', 0)),
            image=request.POST.get('image', ''),
            genres=[g.strip() for g in request.POST.get('genres', '').split(',') if g.strip()],
            category=[c.strip() for c in request.POST.get('category', '').split(',') if c.strip()]
        )

        if updated > 0:
            return JsonResponse({'status': 'success', 'message': 'Álbum actualizado correctamente'})
        return JsonResponse({'status': 'error', 'message': 'El álbum no existe'}, status=404)

    except ValueError as ve:
        return JsonResponse({'status': 'error', 'message': f'Error de valor: {str(ve)}'}, status=400)
    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)}, status=500)


@require_POST
@login_required
def eliminar_album_ajax(request):
    try:
        data = json.loads(request.body)
        code = data.get('album_code')
        if not code:
            return JsonResponse({'status': 'error', 'message': 'No se recibió el código'}, status=400)

        deleted = Album.objects.using('mongodb').filter(code=code).delete()

        if deleted[0] > 0:
            return JsonResponse({'status': 'success', 'message': 'Álbum eliminado correctamente'})
        return JsonResponse({'status': 'error', 'message': 'El álbum no existe'}, status=404)

    except json.JSONDecodeError:
        return JsonResponse({'status': 'error', 'message': 'JSON inválido'}, status=400)
    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)}, status=500)


@require_POST
@login_required
def add_album_to_category(request):
    try:
        data = json.loads(request.body)
        category_code = str(data.get('category_code'))
        album_code = data.get('album_code')

        # Buscamos el álbum primero para obtener su lista actual
        album = Album.objects.using('mongodb').filter(code=album_code).first()

        if not album:
            return JsonResponse({'status': 'error', 'message': 'El álbum no existe'}, status=404)

        if category_code not in album.category:
            nueva_lista = list(album.category)
            nueva_lista.append(category_code)

            # USAR UPDATE EN LUGAR DE SAVE
            Album.objects.using('mongodb').filter(code=album_code).update(category=nueva_lista)

            return JsonResponse({'status': 'success', 'message': 'Álbum asociado correctamente'})

        return JsonResponse({'status': 'info', 'message': 'El álbum ya pertenece a esta categoría'})

    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)}, status=500)


@require_POST
@login_required
def remove_album_from_category(request):
    try:
        data = json.loads(request.body)
        category_code = str(data.get('category_code'))
        album_code = data.get('album_code')

        album = Album.objects.using('mongodb').filter(code=album_code).first()

        if not album:
            return JsonResponse({'status': 'error', 'message': 'El álbum no existe'}, status=404)

        if category_code in album.category:
            nueva_lista = [c for c in album.category if c != category_code]

            # USAR UPDATE EN LUGAR DE SAVE
            Album.objects.using('mongodb').filter(code=album_code).update(category=nueva_lista)

            return JsonResponse({'status': 'success', 'message': 'Álbum desasociado correctamente'})

        return JsonResponse({'status': 'info', 'message': 'El álbum no estaba en esta categoría'})

    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)}, status=500)
@require_POST
@login_required
def get_category_albums(request):
    try:
        data = json.loads(request.body)
        cat_code = data.get('category_code')
        if not cat_code:
            return JsonResponse({'status': 'error', 'message': 'Falta código'}, status=400)

        cat_code_str = str(cat_code)
        albums = Album.objects.using('mongodb').all()
        current_codes = []

        for album in albums:
            category_value = album.category
            if category_value is None:
                continue

            if isinstance(category_value, list):
                if cat_code_str in category_value:
                    current_codes.append(album.code)
            elif isinstance(category_value, str):
                categories = [c.strip() for c in category_value.replace(' ', ',').split(',') if c.strip()]
                if cat_code_str in categories:
                    current_codes.append(album.code)

        return JsonResponse({'status': 'success', 'current_codes': current_codes})

    except json.JSONDecodeError:
        return JsonResponse({'status': 'error', 'message': 'JSON inválido'}, status=400)
    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)}, status=500)


def buscar_albumes(request):
    q = request.GET.get('q', '')
    albumes = Album.objects.using('mongodb').filter(title__icontains=q)[:50]
    results = [{'id': a.code, 'text': f"{a.title} — {', '.join(a.artist)}"} for a in albumes]
    return JsonResponse(results, safe=False)


@login_required
def editar_categoria(request, code):
    categoria = get_object_or_404(Category.objects.using('mongodb'), code=code)

    if request.method == 'POST':
        categoria.name = request.POST.get('name', categoria.name)
        categoria.description = request.POST.get('description', categoria.description)
        categoria.logo = request.POST.get('logo', categoria.logo)
        categoria.save(using='mongodb')
        return redirect('rankingApp:show_categorias_modificar')

    return render(request, 'editar_categoria.html', {'categoria': categoria})


@require_POST
@login_required
def actualizar_albumes_categoria(request):
    try:
        data = json.loads(request.body)
        categoria_code = data.get('categoria_code')
        albumes_codes = [int(c) for c in data.get('albumes_codes', [])]

        albumes_actuales = Album.objects.using('mongodb').filter(category__contains=str(categoria_code))

        for album in albumes_actuales:
            if album.code not in albumes_codes:
                str_cat = str(categoria_code)
                if str_cat in album.category:
                    album.category.remove(str_cat)
                    album.save(using='mongodb')

        for code in albumes_codes:
            album = Album.objects.using('mongodb').filter(code=code).first()
            if album:
                str_cat = str(categoria_code)
                if str_cat not in album.category:
                    album.category.append(str_cat)
                    album.save(using='mongodb')

        return JsonResponse({'status': 'success', 'message': 'Álbumes actualizados correctamente'})

    except json.JSONDecodeError:
        return JsonResponse({'status': 'error', 'message': 'JSON inválido'}, status=400)
    except ValueError:
        return JsonResponse({'status': 'error', 'message': 'Código de álbum inválido'}, status=400)
    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)}, status=500)


def estadisticas_albumes(request):
    # Obtenemos todos los álbumes
    todos_los_albumes = Album.objects.using('mongodb').all()

    # Calculamos el total de asignaciones a categorías
    # (Sumamos cuántas categorías tiene cada álbum en su ArrayField)
    total_asignaciones = sum(len(album.category) for album in todos_los_albumes)

    datos_grafica = []

    for album in todos_los_albumes:
        num_categorias = len(album.category)
        # Calculamos el porcentaje relativo al total de la plataforma
        porcentaje = (num_categorias / total_asignaciones * 100) if total_asignaciones > 0 else 0

        datos_grafica.append({
            'titulo': album.title,
            'artista': ", ".join(album.artist),
            'cantidad': num_categorias,
            'porcentaje': round(porcentaje, 2)
        })

    # Ordenar de mayor a menor porcentaje
    datos_grafica = sorted(datos_grafica, key=lambda x: x['porcentaje'], reverse=True)

    return render(request, 'estadisticas.html', {
        'datos': datos_grafica,
        'total': total_asignaciones
    })


def estadisticas_detalladas(request):
    # Obtenemos todos los rankings y álbumes de MongoDB
    rankings = Ranking.objects.using('mongodb').all()
    albumes = Album.objects.using('mongodb').all()

    # IMPORTANTE: Tus claves en el JSON están en minúsculas (s, a, b, c, d)
    niveles = ['s', 'a', 'b', 'c', 'd']
    conteo_global = {}

    for r in rankings:
        # r.rankingData es el dict que me pasaste
        data = r.rankingData or {}
        for nivel in niveles:
            # Obtenemos la lista [10] o [17, 20], etc.
            album_codes = data.get(nivel, [])
            for code in album_codes:
                # Aseguramos que el código sea entero para comparar con el modelo Album
                c_code = int(code)
                if c_code not in conteo_global:
                    conteo_global[c_code] = {n: 0 for n in niveles}
                    conteo_global[c_code]['total'] = 0

                conteo_global[c_code][nivel] += 1
                conteo_global[c_code]['total'] += 1

    tabla_final = []
    for alb in albumes:
        # Buscamos en el conteo usando el code del álbum (alb.code)
        stats = conteo_global.get(alb.code, {n: 0 for n in niveles + ['total']})
        total = stats['total']

        resumen_niveles = []
        for n in niveles:
            cantidad = stats[n]
            porcentaje = round((cantidad / total * 100), 1) if total > 0 else 0
            resumen_niveles.append({
                'nombre': n.upper(),  # Lo mostramos en Mayúscula en la tabla
                'cantidad': cantidad,
                'porcentaje': porcentaje
            })

        tabla_final.append({
            'titulo': alb.title,
            'artista': ", ".join(alb.artist) if isinstance(alb.artist, list) else alb.artist,
            'niveles': resumen_niveles,
            'total_global': total
        })

    return render(request, 'estadisticas.html', {'tabla': tabla_final})


@require_POST
@login_required
def add_categoria_ajax(request):
    try:
        data = json.loads(request.body)

        # LÓGICA PARA CÓDIGO AUTOMÁTICO
        # Buscamos la categoría con el código más alto y sumamos 1
        ultima_cat = Category.objects.using('mongodb').order_by('-code').first()
        nuevo_codigo = (ultima_cat.code + 1) if ultima_cat else 1

        # Crear la nueva categoría con el código autogenerado
        Category.objects.using('mongodb').create(
            code=nuevo_codigo,
            name=data.get('name'),
            description=data.get('description'),
            logo=data.get('logo')
        )
        return JsonResponse({'status': 'success', 'message': 'Categoría creada'})
    except Exception as e:
        return JsonResponse({'status': 'error', 'message': str(e)})