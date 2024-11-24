def filtrar_negativos():
    lista = input("Introduce los números separados por espacios: ").split()
    lista = [int(x) for x in lista]

    negativos = list(filter(lambda x: x < 0, lista))
    print("Números negativos:", negativos)
filtrar_negativos()
