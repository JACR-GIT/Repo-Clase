def dividir_elementos():
    lista = input("Introduce los elementos de la lista separados por espacios: ").split()
    lista = [int(x) for x in lista]  # Convierte los elementos a enteros
    divisor = int(input("Introduce el divisor: "))

    try:
        resultado = [x / divisor for x in lista]
        print("Resultado de la división:", resultado)
    except ZeroDivisionError:
        print("Error: División por cero.")

dividir_elementos()
