from django.urls import path
from .views import *

app_name = "rankingApp"

urlpatterns = [
    path('albunes/', show_albunes, name="albunes"),
    path('', do_login, name='do_login'),
    path('register/', do_register, name='do_register'),
    path('logout/', logout_user, name='logout_user'),
    path('data_load/', data_load, name='go_data_load'),
    path('show_categorias/', show_categorias_album, name='show_categorias'),
    path('panel_admin/', show_panel_admin, name='panel_admin'),
    path('ranking/<int:category_code>/', show_ranking, name='ranking'),
    path('categorias_modificar/', show_categorias_modificar, name='categorias_modificar'),
    path('review/<int:album_id>/', show_review, name='review'),
    path('albunes_modificar/', show_albunes_modificar, name='albunes_modificar'),
    path('editar-album-ajax/', editar_album_ajax, name='editar_album_ajax'),
    path('eliminar-album-ajax/', eliminar_album_ajax, name='eliminar_album_ajax'),
    path('gestionar_usuarios/', show_gestionar_usuarios, name='gestionar_usuarios'),
    path('show_categorias_modificar/', show_categorias_modificar, name='show_categorias_modificar'),
    path('editar-categoria-ajax/', editar_categoria_ajax, name='editar_categoria_ajax'),
    path('eliminar-categoria-ajax/', eliminar_categoria_ajax, name='eliminar_categoria_ajax'),
    path('add-album-to-category/', add_album_to_category, name='add_album_to_category'),
    path('remove-album-from-category/', remove_album_from_category, name='remove_album_from_category'),
    path('get-category-albums/', get_category_albums, name='get_category_albums'),
    path('editar-categoria/<str:code>/', editar_categoria, name='editar_categoria'),
    path('actualizar-albumes-categoria/', actualizar_albumes_categoria, name='actualizar_albumes_categoria'),
    path('buscar-albumes/', buscar_albumes, name='buscar_albumes'),
    path('estadisticas/', estadisticas_detalladas, name='estadisticas_detalladas'),
    path('add-categoria-ajax/', add_categoria_ajax, name='add_categoria_ajax'),
]