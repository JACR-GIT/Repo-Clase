"""7) Extracción de números.
Extrae todos los números de una cadena que incluye texto y dígitos.
Ejemplo: "Hay 3 gatos y 7 perros" → [3, 7]"""
import re
def extraer_numeros(cadena):
    patron = r"\d"
    return re.findall(patron, cadena)
print(extraer_numeros("Hay 3 gatos y 7 perros"))