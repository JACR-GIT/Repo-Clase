"""15) Validación de números hexadecimales.
Comprueba si un texto contiene un número en formato hexadecimal (ejemplo: #FF5733)."""

import re
def validar_hex(texto):
    patron = r"^#(?:[0-9a-fA-F]{3}){1,2}$"
    return re.search(patron, texto)
print(validar_hex("#FF5733"))