def concatenar_listas():
    n = int(input("¿Cuántas listas deseas concatenar? "))
    listas = []
    for i in range(n):
        lista = input(f"Introduce los elementos de la lista {i + 1} separados por espacios: ").split()
        listas.append([int(x) for x in lista])
    resultado = [elemento for lista in listas for elemento in lista]
    print("Lista concatenada:", resultado)

print(concatenar_listas())
