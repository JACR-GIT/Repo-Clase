def es_primo(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def fibonacci_primos(x):
    a, b = 0, 1
    suma_primos = 0
    for i in range(x):
        print(f"término {i + 1:02d}: {a}", end="")
        if es_primo(a):
            suma_primos += a
            print(" - es primo")
        else:
            print(" - no es primo")
        a, b = b, a + b
    return suma_primos

# Solicitar al usuario el número de términos
x = int(input("Introduce la cantidad de términos: "))
resultado = fibonacci_primos(x)
print(f"La suma de los primos que hay en los {x} primeros números de la sucesión de Fibonacci es {resultado}")