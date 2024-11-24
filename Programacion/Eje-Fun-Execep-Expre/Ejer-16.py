def concatenar_cadenas():
    lista = input("Introduce las palabras separadas por espacios: ").split()

    resultado = " ".join(
        map(str, lista))  # Usa map para convertir cada palabra a cadena y luego join para concatenarlas
    print("Cadena concatenada:", resultado)

concatenar_cadenas()
