def suma_enteros():
    lista = input("Introduce los elementos de la lista separados por espacios: ").split()
    total = 0

    for item in lista:
        try:
            total += int(item)
        except ValueError:
            print(f"Elemento '{item}' no es un número entero, se omite.")

    print("Suma de enteros:", total)

suma_enteros()
