"""Ejercicio 2: Conversión de JSON a Lista de Diccionarios
Dado el fichero JSON “UT3 Deserializacion.json”:
1. Deserializa este JSON en Python para convertirlo en una lista de diccionarios.
2. Imprime solo los nombres de las personas mayores de 30 años."""

import json

# Paso 1: Leer y deserializar el archivo JSON
with open("Ficheros intercambio de datos/UT3 Deserializacion.json", "r") as archivo:
    lista_personas = json.load(archivo)  # Convertimos el JSON a una lista de diccionarios

# Paso 2: Filtrar y mostrar los nombres de personas mayores de 30 años
print("Personas mayores de 30 años:")
for persona in lista_personas:
    if persona.get("edad", 0) > 30:  # Verificamos que la edad sea mayor a 30
        print(persona["nombre"])  # Imprimimos el nombre
