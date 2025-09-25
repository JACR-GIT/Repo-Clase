""" 8) Validación de contraseñas.
Una contraseña debe tener entre 8 y 16 caracteres, incluir al menos una mayúscula, una
minúscula y un número."""

import re
def valicacion_contraseñas(contraseña):
     if len(contraseña) < 8 or len(contraseña) > 16:
          return "La contraseña debe tener entre 8 y 16 caracteres."

     # Expresión regular para validar los requisitos
     patron = r"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$"

     # Validar usando la expresión regular
     if not re.match(patron, contraseña):
          return "La contraseña debe incluir al menos una mayúscula, una minúscula y un número."

     return "La contraseña es válida."

contra = input("Dime tu contraseña:")
print(valicacion_contraseñas(contra))