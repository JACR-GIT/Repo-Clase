"""6) Filtro de palabras con una letra específica.
Encuentra todas las palabras que contienen la letra a """
import re

def filtro_palabras(palabras, letra):
    patron = r"\b\w*"+letra+r"\w*\b"
    return re.findall(patron, palabras)
print(filtro_palabras("soja hola adios nene", "l"))