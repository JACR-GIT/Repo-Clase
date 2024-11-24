def obtener_elemento():
    lista = input("Introduce los elementos de la lista separados por espacios: ").split()
    lista = [int(x) for x in lista]
    indice = int(input("Introduce el índice que deseas obtener: "))

    try:
        print(f"Elemento en el índice {indice}: {lista[indice]}")
    except IndexError:
        print("Error: Índice fuera de rango.")
obtener_elemento()
