def promedio():
    numeros = input("Introduce los números separados por espacios: ").split()
    numeros = [float(x) for x in numeros]

    if numeros:
        return round(sum(numeros) / len(numeros),2)
    else:
        return "No se proporcionaron números."
print(promedio())
