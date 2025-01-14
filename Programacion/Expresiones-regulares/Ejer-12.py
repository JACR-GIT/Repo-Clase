"""12) Extracción de correos de un archivo.
Dado un archivo de texto, encuentra y lista todas las direcciones de correo electrónico"""

import re
def buscar_correos(archivo):
    with open(archivo, 'r') as f:
        contenido = f.read()
    patron = re.compile(r'[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+')
    correos = patron.findall(contenido)
    return correos

archivo = 'archivos_ER/archivo1.txt'
correos = buscar_correos(archivo)
for correo in correos:
    print(correo)