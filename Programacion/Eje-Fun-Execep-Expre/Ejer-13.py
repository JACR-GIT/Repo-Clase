from functools import reduce


def multiplicar_todos_los_elementos():
    lista = input("Introduce los números separados por espacios: ").split()
    lista = [int(x) for x in lista]

    resultado = reduce(lambda x, y: x * y, lista)
    print("Resultado de la multiplicación de todos los elementos:", resultado)

multiplicar_todos_los_elementos()
