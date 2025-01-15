def generar_sublistas():
    lista = input("Introduce los elementos de la lista separados por espacios: ").split()
    lista = [int(x) for x in lista]
    inicio = int(input("Introduce el índice de inicio: "))
    inicio-=1
    fin = int(input("Introduce el índice de fin: "))

    try:
        sublista = lista[inicio:fin]
        print("Sublista generada:", sublista)
    except IndexError:
        print("Error: Índice fuera de rango.")
generar_sublistas()