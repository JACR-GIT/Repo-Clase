def filtrar_multiples_de_3():
    lista = input("Introduce los números separados por espacios: ").split()
    lista = [int(x) for x in lista]

    multiples_de_3 = list(filter(lambda x: x % 3 == 0, lista))
    print("Números múltiplos de 3:", multiples_de_3)
filtrar_multiples_de_3()
