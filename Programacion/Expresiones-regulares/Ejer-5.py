"""5) Validación de fechas.
Comprueba si una fecha tiene el formato dd/mm/yyyy."""
import re
def validar_fecha(fecha):
    patron = r"^\d{1,2}/\d{1,2}/\d{4}$"
    if re.match(patron, fecha):
        return ("Fecha valida")
    else:
        return ("Fecha invalida")

print(validar_fecha("08/1/2025"))