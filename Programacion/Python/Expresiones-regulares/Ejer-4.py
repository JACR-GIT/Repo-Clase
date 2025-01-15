"""4) Extracción de palabras.
Extrae todas las palabras de una cadena. Por ejemplo: "Hola mundo!" debería devolver
["Hola", "mundo"].
"""

import re
def extraer_palabras(texto):
    patron = r"\b\w+\b"
    if re.search(patron, texto):
        return re.findall(patron, texto)
print(extraer_palabras("Hola mundo!"))