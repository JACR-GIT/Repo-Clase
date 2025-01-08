"""1) Validación de direcciones de correo electrónico.
Escribe una expresión regular que valide si una dirección de correo tiene el formato
correcto: usuario@dominio.extension.
Ejemplo: input: prueba@gmail.com -> válido, prueba@gmail@.com -> no válido"""

import re

def validar_correo(correo):
    patron_correo = r'^\w+@\w+\.\w+$'
    if re.match(patron_correo, correo):
        print("El correo es válido.")
    else:
        print("El correo no es valido.")
print(validar_correo("jose@gmail.es"))