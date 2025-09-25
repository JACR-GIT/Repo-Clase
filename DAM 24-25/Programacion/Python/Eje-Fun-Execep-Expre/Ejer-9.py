def buscar_elemento():
    lista = input("Introduce los elementos de la lista separados por espacios: ").split()
    elemento = input("Introduce el elemento que deseas buscar: ")

    try:
        indice = lista.index(elemento)
        print(f"Elemento encontrado en el índice {indice}.")
    except ValueError:
        print("Error: El elemento no se encuentra en la lista.")

buscar_elemento()
