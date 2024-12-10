# Examen - 1ª Evaluación 2023

### Ejercicio 1
# Problema
# El programa debe recibir un texto y devolver el número de letras que sean mayúsculas y consonantes.

def contar_mayusculas_consonantes(texto):
    """Cuenta las consonantes mayúsculas en un texto."""
    consonantes = "BCDFGHJKLMNPQRSTVWXYZ"
    contador = 0
    for letra in texto:
        if letra in consonantes:
            contador += 1
    return contador

# Solución
texto = "Finalmente tras el día de ayer el Real Madrid y el Barcelona siguen adelante en la Copa del Rey"
resultado = contar_mayusculas_consonantes(texto)
print(f"Resultado esperado: {resultado}")  # Resultado esperado: 6

### Explicación
# Definimos las consonantes mayúsculas.
# Iteramos por cada carácter del texto y verificamos si pertenece a las consonantes.
# Incrementamos un contador por cada coincidencia.

### Ejercicio 2
# Problema
# El programa debe recibir una lista de números y devolver aquellos que sean enteros y divisibles entre 2 y 3.

def filtrar_numeros(lista_numeros):
    """Filtra números que sean enteros y divisibles entre 2 y 3."""
    return [num for num in lista_numeros if num % 1 == 0 and num % 2 == 0 and num % 3 == 0]

# Solución
lista_numeros = [4.5, 6, 10.3, 12.4, 15.0, 18, 24]
resultado = filtrar_numeros(lista_numeros)
print(f"Resultado esperado: {resultado}")  # Resultado esperado: [6, 18, 24]

### Explicación
# Comprobamos que el número sea entero (num % 1 == 0).
# Verificamos que sea divisible entre 2 y 3 (num % 2 == 0 and num % 3 == 0).
# Utilizamos comprensión de listas para simplificar el código.

### Ejercicio 3
# Problema
# Valorar futbolistas según las puntuaciones dadas por varias personas.

def valorar_futbolistas(futbolistas, num_personas):
    """Valora futbolistas recogiendo puntuaciones y calculando medias."""
    resultados = {}
    for futbolista in futbolistas:
        print(f"-------------------------VALORACIÓN {futbolista.upper()}-------------------------")
        puntuaciones = []
        for i in range(1, num_personas + 1):
            puntuacion = int(input(f"Persona {i} → "))
            puntuaciones.append(puntuacion)
        media = sum(puntuaciones) / len(puntuaciones)
        resultados[futbolista] = media
    print("\n-----------------------RESUMEN VALORACIONES ----------------------")
    for futbolista, media in resultados.items():
        print(f"{futbolista} (Media Obtenida) → {media:.1f}")

# Solución de ejemplo:
# futbolistas = ["Haaland", "Mbappe", "Vinicius Jr"]
# valorar_futbolistas(futbolistas, 2)

### Explicación
# Solicitamos las puntuaciones para cada futbolista.
# Calculamos la media con sum() y la longitud de las puntuaciones.
# Mostramos los resultados en el formato indicado.

### Ejercicio 4
# Problema
# Realizar diferentes operaciones con una lista de coches representada por diccionarios.

# Apartado A
# Lista de nombres de coches con más de 2 puertas, ordenados por número de puertas.
def coches_por_puertas(lista_coches):
    """Filtra coches con más de 2 puertas y los ordena."""
    filtrados = [coche for coche in lista_coches if coche['puertas'] > 2]
    return sorted(filtrados, key=lambda x: x['puertas'])

coches = [
    {"modelo": "Gallardo", "marca": "Lamborghini", "tipo": "Deportivo", "puertas": 3},
    {"modelo": "Murciélago GT", "marca": "Lamborghini", "tipo": "Carrera", "puertas": 2},
    {"modelo": "Twingo", "marca": "Renault", "tipo": "Normal", "puertas": 5}
]

resultado_a = coches_por_puertas(coches)
print(f"Resultado esperado (Apartado A): {resultado_a}")

# Apartado B
# Coches que pertenecen a una marca pasada como parámetro.
def coches_por_marca(lista_coches, marca):
    """Filtra coches por marca."""
    return [coche for coche in lista_coches if coche['marca'] == marca]

resultado_b = coches_por_marca(coches, "Lamborghini")
print(f"Resultado esperado (Apartado B): {resultado_b}")

# Apartado C
# Crear lista de diccionarios a partir de listas separadas.
def crear_diccionarios(modelos, marcas, tipos, puertas):
    """Construye diccionarios de coches a partir de listas."""
    return [
        {"modelo": modelo, "marca": marca, "tipo": tipo, "puertas": puerta}
        for modelo, marca, tipo, puerta in zip(modelos, marcas, tipos, puertas)
    ]

modelos = ["Gallardo", "Murciélago GT", "Twingo"]
marcas = ["Lamborghini", "Lamborghini", "Renault"]
tipos = ["Deportivo", "Carrera", "Normal"]
puertas = [3, 2, 5]

resultado_c = crear_diccionarios(modelos, marcas, tipos, puertas)
print(f"Resultado esperado (Apartado C): {resultado_c}")

### Explicación
# Apartado A: Filtramos los coches con más de 2 puertas y los ordenamos.
# Apartado B: Comparamos la marca en cada diccionario y devolvemos coincidencias.
# Apartado C: Usamos zip para combinar las listas y construir los diccionarios.


# Examen - 1ª Evaluación 2022

### Ejercicio 1
# Problema
# El programa debe contar cuántas veces aparecen las palabras de una lista en un texto, ignorando mayúsculas, minúsculas y tildes.
import unicodedata

def normalizar_texto(texto):
    """Elimina tildes y normaliza el texto a minúsculas."""
    return ''.join(c for c in unicodedata.normalize('NFD', texto.lower()) if unicodedata.category(c) != 'Mn')

def contar_palabras(lista, texto):
    """Cuenta cuántas veces aparecen las palabras de una lista en el texto."""
    texto_normalizado = normalizar_texto(texto)
    palabras = texto_normalizado.split()
    resultados = {}
    for palabra in lista:
        palabra_normalizada = normalizar_texto(palabra)
        resultados[palabra] = palabras.count(palabra_normalizada)
    return resultados

# Solución
texto = """Ey, Tití me preguntó
Si tengo muchas novia'
Muchas novia'
Hoy tengo a una, mañana otra
Ey, pero no hay boda
Tití me preguntó
Si tengo muchas novia'
Je, muchas novia'
Hoy tengo a una, mañana otra"""

lista = ["TITI", "Novia'", "Casa", "bunny"]
resultado = contar_palabras(lista, texto)
print(f"Resultado esperado: {resultado}")

### Explicación
# Normalizamos el texto y la lista para evitar problemas con tildes y mayúsculas.
# Contamos las apariciones de cada palabra de la lista en el texto dividido en palabras.

### Ejercicio 2
# Problema
# Realizar una encuesta y mostrar un resumen con las respuestas.

def realizar_encuesta(preguntas, num_personas):
    """Realiza preguntas a varias personas y resume las respuestas."""
    respuestas = {pregunta: [] for pregunta in preguntas}
    for i in range(1, num_personas + 1):
        print(f"-------------------------ENTREVISTADO {i}-------------------------")
        for pregunta in preguntas:
            respuesta = input(f"{pregunta} ")
            respuestas[pregunta].append(respuesta)
    print("\n-----------------------RESUMEN ENCUESTA----------------------")
    for i, pregunta in enumerate(preguntas, 1):
        print(f"---------------------------------------------------------------------------")
        print(f"pregunta {i} → {pregunta}")
        print(f"respuestas → {respuestas[pregunta]}")

# Solución de ejemplo:
preguntas = ["Cuál es tu color favorito?", "Cuántos años tienes?"]
# realizar_encuesta(preguntas, 3)

### Explicación
# Creamos un diccionario para almacenar respuestas por pregunta.
# Recopilamos y mostramos respuestas siguiendo el formato solicitado.

### Ejercicio 3
# Problema
# Operar con una lista de diccionarios que representan pokémon.

# Apartado A
# Ordenar pokémon por el número de Pokédex de mayor a menor.

def ordenar_pokedex(lista_pokemon):
    """Ordena los pokémon por el número de Pokédex de mayor a menor."""
    return sorted(lista_pokemon, key=lambda x: x['pokédex'], reverse=True)

pokemones = [
    {"nombre": "Treecko", "pokédex": 252, "tipo": ["PLANTA"], "evo": 1},
    {"nombre": "Roselia", "pokédex": 407, "tipo": ["PLANTA", "VENENO"], "evo": 2},
    {"nombre": "Milotic", "pokédex": 350, "tipo": ["AGUA"], "evo": 2},
    {"nombre": "Altaria", "pokédex": 334, "tipo": ["VOLADOR", "DRAGÓN"], "evo": 2},
]

resultado_a = ordenar_pokedex(pokemones)
print(f"Resultado esperado (Apartado A): {resultado_a}")

# Apartado B
# Devolver la lista de pokémon que tienen un tipo específico pasado como parámetro.

def filtrar_por_tipo(lista_pokemon, tipo):
    """Filtra pokémon por un tipo especificado."""
    return [pokemon for pokemon in lista_pokemon if tipo.upper() in pokemon['tipo']]

resultado_b = filtrar_por_tipo(pokemones, "PLANTA")
print(f"Resultado esperado (Apartado B): {resultado_b}")

# Apartado C
# Construir una lista de diccionarios con una estructura específica.

def construir_pokemon(nombres, numeros, tipos, evo):
    """Construye pokémon a partir de listas separadas."""
    return [{"nombre": n, "pokédex": num, "tipo": t, "evo": e} for n, num, t, e in zip(nombres, numeros, tipos, evo)]

nombres = ["Treecko", "Roselia", "Milotic", "Altaria"]
numeros = [252, 407, 350, 334]
tipos = [["PLANTA"], ["PLANTA", "VENENO"], ["AGUA"], ["VOLADOR", "DRAGÓN"]]
evo = [1, 2, 2, 2]

resultado_c = construir_pokemon(nombres, numeros, tipos, evo)
print(f"Resultado esperado (Apartado C): {resultado_c}")

### Explicación
# Apartado A: Ordenamos los pokémon por el número de Pokédex en orden descendente.
# Apartado B: Filtramos los pokémon que contienen el tipo indicado.
# Apartado C: Usamos zip para combinar las listas y construir diccionarios.

### Ejercicio 4
# Problema
# Mostrar los divisores de un número entre 1 y 10.

def divisores(numero):
    """Devuelve los divisores de un número entre 1 y 10."""
    return [i for i in range(1, 11) if numero % i == 0]

# Solución
numero = 20
resultado = divisores(numero)
print(f"Es divisible por: {resultado}")

### Explicación
# Usamos una lista por comprensión para verificar la divisibilidad del número entre 1 y 10.


# Examen - 1ª Evaluación 2021

### Ejercicio 1
# Problema
# Contar el número de signos de puntuación en un texto.

def contar_signos(texto):
    """Cuenta los signos de puntuación en un texto."""
    signos = {',': 0, '.': 0, ':': 0, '?': 0, '!': 0}
    for caracter in texto:
        if caracter in signos:
            signos[caracter] += 1
    return signos

# Solución
texto = """En las ciudades de Piltover y Zaun, se palpa el desasosiego en el ambiente: inventores,
ladrones, políticos y señores del crimen buscan liberarse de las ataduras de una sociedad fragmentada.
Mientras la rebelión va cobrando fuerza, dos hermanas roban un artefacto de poder inimaginable."""

resultado = contar_signos(texto)
print(f"Resultado esperado: {resultado}")

### Explicación
# Iteramos por cada carácter del texto.
# Incrementamos el contador para cada signo de puntuación encontrado.

### Ejercicio 2
# Problema
# Crear un juego de ahorcado.

def ahorcado(palabra):
    """Simula el juego del ahorcado."""
    vidas = 5
    letras_citadas = []
    progreso = ['_'] * len(palabra)

    while vidas > 0 and '_' in progreso:
        print(f"Vidas: {vidas}")
        print(f"Letras citadas: {letras_citadas}")
        print("Palabra: " + ' '.join(progreso))
        letra = input("Dime una letra: ").lower()
        if letra in letras_citadas:
            print("Ya has dicho esa letra.")
        else:
            letras_citadas.append(letra)
            if letra in palabra:
                print("¡Has acertado!")
                for i, l in enumerate(palabra):
                    if l == letra:
                        progreso[i] = letra
            else:
                print("Fallaste.")
                vidas -= 1

    if '_' not in progreso:
        print("¡Felicidades, ganaste!")
    else:
        print("Perdiste. La palabra era:", palabra)

# Solución de ejemplo:
# ahorcado("patinete")

### Explicación
# Mantenemos un registro de vidas, letras citadas y progreso de la palabra.
# Reducimos vidas si fallan y terminamos el juego cuando no quedan vidas o se adivina la palabra.

### Ejercicio 3
# Problema
# Operar con una lista de alumnos representados por diccionarios.

# Apartado A
# Devolver alumnos cuyo dominio de email sea "safareyes.es".

def alumnos_por_dominio(lista_alumnos, dominio="safareyes.es"):
    """Devuelve los alumnos con un dominio de email específico."""
    return [alumno for alumno in lista_alumnos if alumno['email'].endswith(dominio)]

alumnos = [
    {"nombre": "Enrique", "apellidos": "García, Migueza", "dni": "12345678K", "email": "egarciamigueza@safareyes.es"},
    {"nombre": "Paloma", "apellidos": "Machado, López", "dni": "12345678Z", "email": "pmachadolopez@hotmail.es"},
    {"nombre": "Antonio", "apellidos": "Romero, Domínguez", "dni": "12345678A", "email": "aromerodominguez@safareyes.es"}
]

resultado_a = alumnos_por_dominio(alumnos)
print(f"Resultado esperado (Apartado A): {resultado_a}")

### Explicación
# Usamos endswith() para comprobar si el email termina con el dominio especificado.
# Filtramos los alumnos que cumplen la condición y los devolvemos.

# Apartado B
# Devolver al primer alumno de la lista, tomando como orden el primer apellido en orden alfabético.

def primer_por_apellido(lista_alumnos):
    """Devuelve el primer alumno según el primer apellido en orden alfabético."""
    return sorted(lista_alumnos, key=lambda x: x['apellidos'])[0]

resultado_b = primer_por_apellido(alumnos)
print(f"Resultado esperado (Apartado B): {resultado_b}")

### Explicación
# Ordenamos la lista de alumnos según la clave 'apellidos'.
# Devolvemos el primer elemento de la lista ordenada.

# Apartado C
# Devolver al primer alumno de la lista, tomando como orden la letra del DNI en orden alfabético.

def primer_por_dni(lista_alumnos):
    """Devuelve el primer alumno según la letra del DNI en orden alfabético."""
    return sorted(lista_alumnos, key=lambda x: x['dni'][-1])[0]

resultado_c = primer_por_dni(alumnos)
print(f"Resultado esperado (Apartado C): {resultado_c}")

### Explicación
# Extraemos la última letra del DNI con [-1].
# Ordenamos la lista según esta letra y devolvemos el primer elemento.

### Ejercicio 4
# Problema
# Calcular la media de una lista de notas y devolver una calificación según el rango de la media.

def evaluar_notas(notas):
    """Calcula la media de las notas y devuelve una calificación según la media."""
    media = sum(notas) / len(notas)
    if media < 5:
        return "Suspenso"
    elif media < 7:
        return "Aprobado"
    elif media < 9:
        return "Notable"
    else:
        return "Sobresaliente"

notas = [5.6, 7, 6.2, 8]
resultado = evaluar_notas(notas)
print(f"Resultado esperado: {resultado}")

### Explicación
# Calculamos la media con sum() dividido entre la longitud de la lista.
# Evaluamos la media en diferentes rangos y devolvemos el texto correspondiente.

### Ejercicio 5
# Problema
# Comprobar si una contraseña es segura según criterios específicos.

def validar_contraseña(contraseña):
    """Verifica si una contraseña cumple con los requisitos de seguridad."""
    simbolos = {'.', '_', '#'}
    tiene_simbolo = any(c in simbolos for c in contraseña)
    return (
        contraseña[0].isupper() and
        contraseña[-1].isupper() and
        any(c.isdigit() for c in contraseña) and
        tiene_simbolo
    )

contraseña = "A123_bZ"
resultado = validar_contraseña(contraseña)
print(f"Resultado esperado: {resultado}")  # True o False

### Explicación
# Verificamos que la contraseña empiece y termine con una letra mayúscula.
# Comprobamos que contenga al menos un número y uno de los símbolos permitidos.
# Usamos funciones como isupper(), isdigit() y any() para validar las condiciones.
