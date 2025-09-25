"""Crea una función saludaSegunHora, que admita un número indeterminado de parámetros (que
serán nombres de personas).
Si la hora actual es antes de las 6 o las 20 o más, devolverá "Buenas noches".
Si la hora actual son las 6 o más, pero menos que las 12, devolverá: "Buenos días".
Si la hora actual son las 12 o más, pero menos que las 20, devolverá: "Buenas tardes".
Además, dependiendo del número de parámetros, devolverá solo el saludo o lo acompañará de los
nombres de la siguiente manera:
Deberá devolver:
Es importante respetar los signos de puntuación (terminar el saludo con el punto, separar el vocativo
con una coma y, si hay más de un nombre, anteponer “y” al último elemento de la lista).
NOTA: Antepondremos “y” al último elemento, aunque este empiece por el sonido /i/. Lo correcto
(salvo que sea un diptongo) sería poner “e”, pero para no complicar más el ejercicio.
Ej: “Buenas tardes, Juan y Inés.” (aunque lo correcto sería “Buenas tardes, Juan e Inés.”).
Para recuperar el momento actual podemos utilizar datetime.now() y de ahí extraer la hora. Para
poder usarlo habrá que utilizar:
from datetime import datetime"""

from datetime import datetime
def saludaSegunHora(*nombres):
    nombres = list(nombres)
    if datetime.now().hour < 6 and datetime.now().hour >= 20:
        print(f"Buenas noches, {nombres}.")
    elif datetime.now().hour < 12 and datetime.now().hour >= 6:
        print(f"Buenas dias, {nombres}.")
    elif datetime.now().hour < 20 and datetime.now().hour >= 12:
        print(f"Buenas tarde, {nombres}.")

print(saludaSegunHora("Juan", "Ines", "Natalia"))
print(saludaSegunHora("Juan"))
print(saludaSegunHora())