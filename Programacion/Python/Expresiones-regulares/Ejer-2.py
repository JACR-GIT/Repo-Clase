"""2) Comprobación de números telefónicos.
Valida si un número tiene el formato español: +34 123 456 789 o 123 456 789 (pudiendo
separarse los números en distintas agrupaciones o no separarse para nada)."""

import re

def validar_telefono(numero):
    patron = r'^\+34 ?(\d{3} ?){2}\d{3}$'
    patron1 = r'^(\d{3} ?){2}\d{3}$'
    if re.search(patron, numero):
        return ("Numero valido")
    elif re.search(patron1, numero):
        return ("Numero valido")
    else:
        return ("Numero no valido")

print(validar_telefono("123456789"))