"""19) Conteo de palabras clave.
Cuenta cuántas veces aparece cada palabra clave de una lista en un archivo."""

import re
def contar_palabras(archivo, palabras):
    # Abre y lee el contenido del archivo
    with open(archivo, "r") as f:
        texto = f.read()
    # Diccionario para almacenar los resultados
    resultados = {}
    # Busca cada palabra y cuenta las coincidencias
    for palabra in palabras:
        # Contamos la cantidad de coincidencias ignorando mayúsculas/minúsculas
        resultados[palabra] = len(re.findall(palabra, texto, re.IGNORECASE))
    return resultados
# Ejecución
archivo = "archivos_ER/archivo2.txt"
palabras_clave = ["INFO", "ERROR", "WARNING"]
resultado = contar_palabras(archivo, palabras_clave)

if resultado is not None:
    for palabra, conteo in resultado.items():
        # Imprime el resultado de forma legible
        print(f"{palabra}: {conteo}")