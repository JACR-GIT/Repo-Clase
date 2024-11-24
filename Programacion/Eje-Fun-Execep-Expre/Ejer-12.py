def elevar_al_cubo():
    lista = input("Introduce los números separados por espacios: ").split()
    lista = [int(x) for x in lista]

    cubos = list(map(lambda x: x ** 3, lista))
    print("Números elevados al cubo:", cubos)
elevar_al_cubo()
