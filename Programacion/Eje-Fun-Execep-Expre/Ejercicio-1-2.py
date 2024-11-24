def sum_lista(*lista):
    suma = 0
    for i in lista:
        suma += int(i)
    return suma

listaNum = input("Dime la lista de numeros separadas por ,: ")
lista=listaNum.split(",")
print(lista)
print("Total: ", sum_lista(*lista))


def max_min(*lista):
    maxi = 0
    mini = 1
    for i in lista:
        if int(i) > int(maxi):
            maxi = i

    for i in lista:
        if int(i) < int(mini):
            mini = i
    return maxi,mini

print('El resultado es: ', max_min(*lista))