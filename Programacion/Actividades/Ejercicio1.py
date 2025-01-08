
# Datos de los alumnos

Alumnos = {
    "Ana": {"pelo": "negro", "edad": 16},
    "María": {"pelo": "rubio", "edad": 17},
    "Sonia": {"pelo": "rubio", "edad": 23},
    "Javi": {"pelo": "rubio", "edad": 21},
    "Andrés": {"pelo": "castaño", "edad": 17},
    "Pablo": {"pelo": "negro", "edad": 15},
    "Juan": {"pelo": "pelirrojo", "edad": 21},
}

# Datos actividades

natacion= {"Ana", "María", "Sonia", "Juan"}
ingles= {"María", "Sonia", "Pablo", "Juan"}
piano= {"Ana", "Javi"}
taekwondo= {"Javi", "Andrés", "Pablo"}

#Numero1
print(ingles.union(natacion))

#Numero2
print(taekwondo.difference(piano))

#Numero3
conj1 = set()
for alumno in taekwondo.difference(piano):
    conj1.add( Alumnos [alumno]["pelo"])

print(conj1)

#Numero4
conj2 = set()
for alumno in natacion:
    conj2.add(Alumnos [alumno]["pelo"])

print(sorted(conj2))

#Numero5
for alumno in ingles.union(natacion):
    print("El alumno " + alumno + " tiene el pelo de color " + Alumnos[alumno]["pelo"] + " y tiene " + str(Alumnos[alumno]["edad"]) + " años.")

#Numero6: Muestra la edad media de los alumnos que van a inglés o a taekwondo (pero no a ambos) y son mayores de edad
conj3 = set()
for alumno in ingles:
    if Alumnos[alumno]["edad"] >= 18:
        conj3.add(Alumnos[alumno]["edad"])
edad1 = round(sum(conj3)/len(conj3))
print("La media de edad en los que son mayores de edad en ingles es: " + str(edad1) + ".")

conj4 = set()
for alumno in taekwondo:
    if Alumnos[alumno]["edad"] >= 18:
        conj4.add(Alumnos[alumno]["edad"])
edad2 = round(sum(conj4)/len(conj4))
print("La media de edad en los que son mayores de edad en ingles es: " + str(edad2) + ".")

#Numero7 Muestra los nombres de los alumnos ordenados por edad de menor a mayor
conj5 = []
for alumno in Alumnos:
    conj5.append((Alumnos[alumno]["edad"],alumno))
conj5 = sorted(conj5)
for edad, alumno in conj5:
    print(alumno)