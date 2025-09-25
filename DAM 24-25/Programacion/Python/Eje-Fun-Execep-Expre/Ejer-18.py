def incrementar_elementos():
    lista = input("Introduce los números separados por espacios: ").split()
    lista = [int(x) for x in lista]
    incremento = int(input("Introduce el valor de incremento: "))

    resultado = list(map(lambda x: x + incremento, lista))
    print("Lista con incremento:", resultado)
incrementar_elementos()
