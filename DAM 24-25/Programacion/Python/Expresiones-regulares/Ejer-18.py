"""18) Filtrar líneas de un archivo CSV.
Dado un archivo CSV, filtra las líneas cuyo primer campo es un correo electrónico válido. El
fichero CSV de salida solo contendrá las líneas que cumplen esta condición."""

import re
def filtrar_correo(archivo):
    patron = r"^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+"
    with open(archivo, "r") as f:
        for linea in f:
            if re.match(patron, linea.split(",")[0]):
                print(linea, end="")
print(filtrar_correo("archivos_ER/archivo3.csv"))