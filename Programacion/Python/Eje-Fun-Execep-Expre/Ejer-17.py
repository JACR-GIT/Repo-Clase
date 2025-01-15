def filtrar_por_longitud():
    lista = input("Introduce las palabras separadas por espacios: ").split()
    longitud = int(input("Introduce la longitud mínima de las palabras: "))

    resultado = list(filter(lambda x: len(x) >= longitud, lista))
    print("Palabras con longitud mayor o igual a", longitud, ":", resultado)
filtrar_por_longitud()
