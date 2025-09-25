personas = [("Ana", 20),("Carlos", 17), ("Luis", 22), ("Pedro", 15)]
listAux= list()

for pos,elemento in enumerate(personas):
    if pos==0:
        listAux.append(elemento)
    else:
        posAux= 0
        while posAux<len(listAux) and elemento[1] > listAux[posAux][1]:
            posAux+= 1
        listAux.insert(posAux,elemento)
print(listAux)