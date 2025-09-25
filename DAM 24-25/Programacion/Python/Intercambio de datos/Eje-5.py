"""Ejercicio 5: Procesar un JSON Jerárquico
Dado el JSON Json2.son:
1. Escribe un programa que deserialice el JSON y muestre todos los productos con su
precio.
2. Calcula el valor total del inventario (precio x stock) y muestra el resultado"""

import json

# Paso 1: Leer y deserializar el archivo JSON
with open("Ficheros intercambio de datos/Json2.json", "r") as archivo:
    datos = json.load(archivo)  # Deserializar el JSON a un objeto Python

# Paso 2: Mostrar todos los productos con su precio
print("Productos y sus precios:")
valor_total_inventario = 0  # Inicializar el total del inventario

for producto in datos["productos"]:  # Accedemos a la lista de productos
    nombre = producto["nombre"]
    precio = producto["detalles"]["precio"]  # Precio dentro de la clave 'detalles'
    stock = producto["detalles"]["stock"]  # Stock dentro de la clave 'detalles'

    print(f"- {nombre}: ${precio}")

    # Paso 3: Calcular el valor total del inventario
    valor_total_inventario += precio * stock

# Mostrar el valor total del inventario
print(f"\nValor total del inventario: ${valor_total_inventario:.2f}")
