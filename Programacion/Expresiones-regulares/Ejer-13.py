"""13) Reemplazo de palabras prohibidas.
Censura palabras de una lista en un texto.
Ejemplo: Prohíbe "malo", "feo".
"Es muy malo y feo" → "Es muy **** y ****"""

import re
def censor(texto, words):
    for word in words:
        texto = re.sub(word, "****", texto)
    return texto
print(censor("Es muy malo y feo", ["malo", "feo"]))