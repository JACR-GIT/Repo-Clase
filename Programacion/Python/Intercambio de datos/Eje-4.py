"""Ejercicio 4: Creación de XML Dinámico
Escribe un programa que:
1. Reciba una lista de diccionarios en Python, donde cada diccionario representa un
producto con claves nombre, precio, y stock.
Ejemplo:
productos = [
{"nombre": "Teclado", "precio": 20.5, "stock":
15},
{"nombre": "Ratón", "precio": 10.0, "stock": 25}
]
2. Cree un archivo XML estructurado como:
<productos>
<producto>
<nombre>Teclado</nombre>
<precio>20.5</precio>
<stock>15</stock>
</producto>
<producto>
<nombre>Ratón</nombre>
<precio>10.0</precio>
<stock>25</stock>
</producto>
</productos>
Guarde este XML en un archivo llamado productos.xml."""

import xml.etree.ElementTree as ET

# Paso 1: Lista de productos
productos = [
    {"nombre": "Teclado", "precio": 20.5, "stock": 15},
    {"nombre": "Ratón", "precio": 10.0, "stock": 25}
]

# Paso 2: Crear la estructura XML
# Crear el elemento raíz <productos>
raiz = ET.Element("productos")

# Crear cada <producto> con sus subelementos
for producto in productos:
    elemento_producto = ET.SubElement(raiz, "producto")  # Crear <producto>
    ET.SubElement(elemento_producto, "nombre").text = producto["nombre"]  # Crear <nombre>
    ET.SubElement(elemento_producto, "precio").text = str(producto["precio"])  # Crear <precio>
    ET.SubElement(elemento_producto, "stock").text = str(producto["stock"])  # Crear <stock>

# Paso 3: Guardar el XML en un archivo
# Convertir el árbol XML en una cadena y guardar
arbol = ET.ElementTree(raiz)
arbol.write("productos.xml", encoding="utf-8", xml_declaration=True)

print("Archivo 'productos.xml' creado con éxito.")
