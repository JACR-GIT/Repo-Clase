"""10) Extracción de hashtags.
Extrae todos los hashtags de un tweet"""
import re
def extract_hashtags(texto):
    patron = r"#\w+"
    return re.findall(patron, texto)

print(extract_hashtags("Hola, soy @jose y estoy #programando en #python"))