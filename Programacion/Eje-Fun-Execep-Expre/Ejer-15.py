from functools import reduce


def calcular_factorial():
    numero = int(input("Introduce un número para calcular su factorial: "))

    lista = list(range(1, numero + 1))
    factorial = reduce(lambda x, y: x * y, lista)
    print(f"El factorial de {numero} es: {factorial}")
calcular_factorial()
