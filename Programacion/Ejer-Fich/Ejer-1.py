def eliminaCaracteres(frase):
    fraseSalida = frase
    for i in fraseSalida:
        if not i.isalpha() and i != " ":
            fraseSalida = fraseSalida.replace(i, "")
    return fraseSalida


with open("cancion.txt","r") as fichero:
    listaVersos = fichero.readlines()

listaPalabras = list()
diccionario = dict()
for pos,i in enumerate(listaVersos):
    listaVersos[pos] = eliminaCaracteres(listaVersos[pos])
    listaPalabras.extend(listaVersos[pos].split())
    cuentaPalabras = len(listaVersos[pos].split())
    print(f"El verso {pos+1} tiene {cuentaPalabras} palabras")

palabraMasLarga=""
for palabra in listaPalabras:
    if palabra not in diccionario:
        diccionario[palabra] = 1
    else:
        diccionario[palabra] += 1

    if len(palabra) > len(palabraMasLarga):
        palabraMasLarga = palabra

print(f"La palabra más larga que aparece en la canción es {palabraMasLarga}")


listaTuplas = list()
for palabra in diccionario:
    listaTuplas.append((palabra,diccionario[palabra]))

listaOrdenada=sorted(listaTuplas,key=lambda tupla:tupla[1],reverse=True)
# print(listaOrdenada)
listaSalida = list()
longitudPalabra=0
for pos, elem in enumerate(listaOrdenada):
    if pos == 0:
        listaSalida.append(elem[0])
        longitudPalabra=elem[1]
    elif longitudPalabra == elem[1]:
        listaSalida.append(elem[0])
    else:
        break
print(f"La palabra (o palabras) más repetida es: {listaSalida}")