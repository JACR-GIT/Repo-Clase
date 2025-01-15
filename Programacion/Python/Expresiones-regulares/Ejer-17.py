"""17) Sacar números de un archivo.
Extrae todos los números de un archivo de texto"""

import re
def extraer_numeros(archivo):
    with open(archivo, "r") as f:
        contenido = f.read()
    return re.findall(r"\d+", contenido)
archivo = "archivos_ER/archivo1.txt"
numeros = extraer_numeros(archivo)
for numero in numeros:
    print(numero)
