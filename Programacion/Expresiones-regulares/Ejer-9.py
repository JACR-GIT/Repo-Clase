"""9) Búsqueda de URLs.
Encuentra todas las URLs de un texto.
Ejemplo: "Visita http://example.com o https://www.google.com"."""
import re

def buscar_url(texto):
    patron = r"https?://[a-zA-Z0-9.-]+"
    urls = re.findall(patron, texto)
    return urls

texto = "Visita http://example.com o https://www.google.com"
print(buscar_url(texto))