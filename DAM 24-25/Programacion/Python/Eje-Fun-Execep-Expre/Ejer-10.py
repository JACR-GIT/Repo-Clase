def convertir_a_entero():
    lista = input("Introduce las cadenas de texto separadas por espacios: ").split()
    resultado = []

    for item in lista:
        try:
            resultado.append(int(item))
        except ValueError:
            print(f"Error: '{item}' no se puede convertir a entero.")

    print("Lista convertida a enteros:", resultado)

convertir_a_entero()
