lista_direcciones = ["gira", "izquierda",
"izquierda", "derecha", "arriba", "derecha", "arriba",
"izquierda", "retrocede", "avanza", "abajo", "derecha",
"arriba", "gira", "avanza", "izquierda", "derecha", "abajo",
"arriba", "avanza", "retrocede", "izquierda", "gira",
"arriba", "derecha", "abajo", "avanza", "izquierda",
"derecha", "arriba", "abajo", "izquierda", "derecha",
"derecha", "izquierda", "arriba", "abajo", "izquierda",
"derecha", "arriba", "abajo", "izquierda", "derecha",
"arriba", "abajo", "derecha", "izquierda", "arriba" ]

diccio = dict()
listaB = list()
listaC = list()
listaD = list()

for pos,elemento in enumerate(lista_direcciones):
    #Apartado A
    if elemento in diccio.keys():
        diccio[elemento] = diccio[elemento] + 1
    else:
        diccio[elemento] = 1

    #Apartado C
    listaC.append(len(elemento))

    #Apartado B
    if pos%2==0:
        listaB.append(elemento[::-1])
        #Apartado D
        listaD.append(listaC[pos]**2)
    else:
        listaB.append(elemento.upper())
        listaD.append(listaC[pos] * pos)


print(diccio)
print(listaB)
print(listaC)
print(listaD)


