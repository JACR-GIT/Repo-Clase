"""Ejercicio 3: Procesamiento Básico de XML
Dado el fichero XML “UT3 Deserializacion.xml”:
1. Usa xml.etree.ElementTree para extraer los nombres y edades de todos los
empleados.
2. Imprime solo los empleados mayores de 40 años."""

import xml.etree.ElementTree as ET

# Paso 1: Leer el archivo XML y parsearlo
tree = ET.parse("Ficheros intercambio de datos/UT3 Deserializacion.xml")  # Carga y analiza el fichero XML
root = tree.getroot()  # Obtiene el nodo raíz del árbol XML

# Paso 2: Extraer nombres y edades de los empleados
print("Empleados mayores de 40 años:")
for empleado in root.findall("empleado"):  # Encuentra todas las etiquetas <empleado>
    nombre = empleado.find("nombre").text  # Obtiene el valor de la etiqueta <nombre>
    edad = int(empleado.find("edad").text)  # Obtiene y convierte el valor de la etiqueta <edad> a entero

    # Paso 3: Imprimir solo empleados mayores de 40 años
    if edad > 40:
        print(f"Nombre: {nombre}, Edad: {edad}")
