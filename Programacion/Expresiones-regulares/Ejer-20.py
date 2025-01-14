"""20) Extracción de fechas de un archivo de log.
Encuentra todas las fechas en formato dd/mm/yyyy de un archivo de registro"""
import re


def extraer_fecha(archivo: str) -> list[str]:
    """
    Extrae todas las fechas en formato dd/mm/aaaa de un archivo .csv.

    :param archivo: Ruta al archivo .csv de donde se extraerán las fechas.
    :return: Una lista con todas las fechas encontradas.
    """
    try:
        with open(archivo, 'r', encoding='utf-8') as file:
            content = file.read()

        # Expresión regular para fechas en formato dd/mm/aaaa
        fechas = re.findall(r'\b\d{4}-\d{2}-\d{2}\b', content)
        return fechas
    except FileNotFoundError:
        print(f"Error: El archivo '{archivo}' no existe.")
        return []
    except Exception as e:
        print(f"Error: {e}")
        return []


# Ejemplo de uso
archivo_csv = 'archivos_ER/archivo3.csv'
fechas_extraidas = extraer_fecha(archivo_csv)

if fechas_extraidas:
    print("Fechas encontradas:")
    for fecha in fechas_extraidas:
        print(fecha)
else:
    print("No se encontraron fechas.")
    