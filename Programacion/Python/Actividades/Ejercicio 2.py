import random

def funcion_aleatorio(a, b, n):
    numeros_aleatorios = random.sample(range(a, b), n)
    return numeros_aleatorios

v1 = int(input("Valor minimo del rango--> "))
v2 = int(input("Valor maximo del rango--> "))
nv = int(input("Numero de valores--> "))

print(sorted(funcion_aleatorio(v1, v2, nv)))