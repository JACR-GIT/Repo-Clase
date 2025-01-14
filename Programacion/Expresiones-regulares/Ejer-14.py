"""14) Separación de párrafos.
Divide un texto en párrafos según saltos de línea"""
import re
def separar_parrafo(texto):
    return re.split(r"\n+", texto)

print(separar_parrafo("Hola Mundo asd sadfaaf fsafaf"))