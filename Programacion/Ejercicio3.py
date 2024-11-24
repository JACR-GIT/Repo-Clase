import random

def listas_aleatorias():
    lista1 = sorted(random.sample(range(1,16),5))
    lista2 = sorted(random.sample(range(16,31),5))
    lista3 = sorted(random.sample(range(31,46),5))
    lista3 [2] = " "
    lista4 = sorted(random.sample(range(46,61),5))
    lista5 = sorted(random.sample(range(61,76),5))
    return lista1,lista2,lista3,lista4,lista5
print(listas_aleatorias())