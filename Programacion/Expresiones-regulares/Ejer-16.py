"""16) Buscar líneas con una palabra específica.
Busca todas las líneas que contienen la palabra "error" en un archivo"""
import re
def buscar_palabra(archivo, palabra):
    with open(archivo, "r") as f:
        for linea in f:
            if re.search(palabra, linea):
                print(linea)
archivo2 = "archivos_ER/archivo2.txt"
print(buscar_palabra(archivo2, "ERROR"))