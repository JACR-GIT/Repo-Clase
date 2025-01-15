"""Recorrido simple: Dada una lista de nombres ["Ana", "Juan", "Carlos",
"Marta"], recorre la lista y muestra cada nombre en mayúsculas.
No imprimas la lista tal cual. Genera una cadena de texto de salida que vaya
actualizándose por cada elemento, separando del anterior con una coma y espacio,
salvo que sea el último, que lo hará con una “ y ”"""

nombres = ["Ana", "Juan", "Carlos", "Marta"]
resultado = ""

for i, nombre in enumerate(nombres):
    if i == len(nombres) - 1:
        resultado += "y " + nombre.upper()
    else:
        resultado += nombre.upper() + ", "

print(resultado)
