def convertir_a_mayusculas():
    lista = input("Introduce las palabras separadas por espacios: ").split()

    resultado = list(map(lambda x: x.upper(), lista))
    print("Lista con palabras en mayúsculas:", resultado)

convertir_a_mayusculas()
