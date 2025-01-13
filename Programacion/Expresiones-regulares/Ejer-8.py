""" 8) Validación de contraseñas.
Una contraseña debe tener entre 8 y 16 caracteres, incluir al menos una mayúscula, una
minúscula y un número."""

import re
def valicacion_contraseñas(contraseña):
     patron = r"[]"

contra = input("Dime tu contraseña:")
print(valicacion_contraseñas(contra))