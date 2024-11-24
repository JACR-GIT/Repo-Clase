def contar_numeros_positivos_negativos():
    lista = input("Introduce los números separados por espacios: ").split()
    lista = [int(x) for x in lista]

    positivos = len(list(filter(lambda x: x > 0, lista)))
    negativos = len(list(filter(lambda x: x < 0, lista)))

    print(f"Números positivos: {positivos}")
    print(f"Números negativos: {negativos}")

contar_numeros_positivos_negativos()
