import random

def num_rand():
    return random.sample(range(1,76),1)[0]

def listas_aleatorias():
    lista1 = sorted(random.sample(range(1,16),5))
    lista2 = sorted(random.sample(range(16,31),5))
    lista3 = sorted(random.sample(range(31,46),5))
    lista3 [2] = " "
    lista4 = sorted(random.sample(range(46,61),5))
    lista5 = sorted(random.sample(range(61,76),5))
    return [lista1,lista2,lista3,lista4,lista5]

def funcion_bonita(lista):
    for i in range(5):
        for a in lista:
            if i < len(a):
                 print(f"| {str(a[i]):<3}|", end= "  ")
            else:
                print("     ",  end= '  ')
        print()

def cambiar_num(carton, num):
    for i in (range(5)):
        for j in range(5):
           if carton[i][j]== num:
                carton[i][j]="X"
    return carton


#funcion_bonita(listas_aleatorias())
num_ale=num_rand()
print("El numero aleatorio es: " + str(num_ale) + ".")
funcion_bonita(cambiar_num(listas_aleatorias(), num_ale))