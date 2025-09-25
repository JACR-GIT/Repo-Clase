"""Ejercicio 1: Serialización y Deserialización JSON
Escribe un programa que:
1. Cree un diccionario con información de 5 productos, cada uno con nombre, precio y
cantidad.
2. Serialice el diccionario a una cadena JSON y lo guarde en un archivo llamado
productos.json.
3. Lea el archivo y deserialice el contenido, imprimiendo la información de los
productos.
"""

import json
import json

# Paso 1: Crear un diccionario con información de 5 productos
productos = {
    "productos": [
        {"nombre": "Manzanas", "precio": 1.5, "cantidad": 10},
        {"nombre": "Plátanos", "precio": 0.8, "cantidad": 20},
        {"nombre": "Naranjas", "precio": 1.2, "cantidad": 15},
        {"nombre": "Peras", "precio": 1.8, "cantidad": 8},
        {"nombre": "Uvas", "precio": 2.5, "cantidad": 5}
    ]
}

# Paso 2: Serializar el diccionario a una cadena JSON y guardarlo en un archivo
with open("productos.json", "w") as archivo:
    json.dump(productos, archivo, indent=4)  # indent=4 para hacerlo más legible

print("Archivo 'productos.json' creado con éxito.")

# Paso 3: Leer el archivo y deserializar el contenido
with open("productos.json", "r") as archivo:
    datos_leidos = json.load(archivo)  # Deserializar el archivo JSON

# Imprimir la información de los productos
print("\nInformación de los productos:")
for producto in datos_leidos["productos"]:
    print(f"Nombre: {producto['nombre']}, Precio: {producto['precio']}, Cantidad: {producto['cantidad']}")
