"""3) Validación de código postal.
Comprueba si una cadena de texto es un código postal válido (5 dígitos). Ejemplo: 28080 ->
válido, 2808 -> no válido.
"""
import re

def validar_codigo_postal(codigo_postal):
    patron = r"^\d{5}$"
    if re.match(patron, codigo_postal):
        return "Codigo postal valido"
    else:
        return "Codigo postal no valido"

print(validar_codigo_postal("12345"))