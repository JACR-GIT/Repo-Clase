import random

from Ejercicio3 import listas_aleatorias

#Variables del programa
#Variables para el menu
opcion = 0
opcion1 = 0

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

natacion = {"Ana", "María", "Sonia", "Juan"}
ingles = {"María", "Sonia", "Pablo", "Juan"}
piano = {"Ana", "Javi"}
taekwondo = {"Javi", "Andrés", "Pablo"}

#Funciones del programa
#Ejercicio2 listas aleatorias

def funcion_aleatorio(a, b, n):
    numeros_aleatorios = random.sample(range(a, b), n)
    return numeros_aleatorios

#Ejercicio3 listas aleatorias con rango

def listas_aleatorias():
    lista1 = sorted(random.sample(range(1,16),5))
    lista2 = sorted(random.sample(range(16,31),5))
    lista3 = sorted(random.sample(range(31,46),5))
    lista3 [2] = " "
    lista4 = sorted(random.sample(range(46,61),5))
    lista5 = sorted(random.sample(range(61,76),5))
    return lista1,lista2,lista3,lista4,lista5

#Ejercicio4 funcion bonita

def funcion_bonita(lista):
    for i in range(5):
        for a in lista:
            if i < len(a):
                 print(f"| {str(a[i]):<3}|", end= " ")
            else:
                print(" / ",  end= ' / ')
        print()
    return

#Ejercicio5 numero aleatorio

def num_rand():
    return random.sample(range(1,76),1)[0]

#Ejercicio5 cambiar numero por una X

def cambiar_num(carton, num):
    for i in (range(5)):
        for j in range(5):
           if carton[i][j]== num:
                carton[i][j]="X"
    return carton





# Verificar que la opción esté entre 1 y 6
while opcion < 1 or opcion > 6:
    print("Bienvenido , que ejercicio le gustaria ejecutar (porfavor indicar con numeros).")
    print("1) Ejecuta los ejercicios de estructuras .")
    print("2) Llamara a una funcion que devuelve una serie de 'n' numeros aleatorios sin repetir , entre dos valores y ademas ordenados ")
    print("3) Llamara a una funcion que genera 5 listas de numeros aleatorios ordenados")
    print("4) Mostrara los elementos generados en el ejercio anterior formados por columnas y con un formato")
    print("5) Partiendo del ejercicio anterior , llamara a una funcion que extraiga un numero aleatorio entre 1 y 75 , si el numero existe entre los generados se imprime cambiando el numero por X ")
    print("6) Jugamos al Bingo")
    opcion = int(input("Seleccione una opción (1-6): "))

    # Ejecutar la opción seleccionada
    if opcion == 1:

        # Verificar que la opción esté entre 1 y 6
        while opcion1 < 1 or opcion1 > 7:

            print("1) Muestra por pantalla los nombres aquellos alumnos que están en inglés o en natación")
            print("2) Muestra los nombres de los que están en taekwondo pero no están en piano")
            print("3) Lista los colores de pelo (sin repetir) de los alumnos en taekwondo y no en piano")
            print("4) Muestra los colores de pelo (sin repetir) de las personas que hacen natación, ordenados alfabéticamente.")
            print("5) Muestra por pantalla los alumnos que van tanto a inglés como a natación, mostrando su nombre, edad y color de pelo.")
            print("6) Muestra la edad media de los alumnos que van a inglés o a taekwondo (pero no a ambos) y son mayores de edad")
            print("7) Muestra los nombres de los alumnos ordenados por edad de menor a mayor")

            opcion1 = int(input("Seleccione una opción (1-7):"))

            if opcion1 == 1:
                # Numero1
                print(ingles.union(natacion))
                break
            elif opcion1 == 2:
                # Numero2

                print(taekwondo.difference(piano))
                break
            elif opcion1 == 3:
                # Numero3

                conj1 = set()
                for alumno in taekwondo.difference(piano):
                    conj1.add(Alumnos[alumno]["pelo"])
                print(conj1)
                break
            elif opcion1 == 4:
                # Numero4

                conj2 = set()
                for alumno in natacion:
                    conj2.add(Alumnos[alumno]["pelo"])
                print(sorted(conj2))
                break
            elif opcion1 == 5:
                # Numero5

                for alumno in ingles.union(natacion):
                    print("El alumno " + alumno + " tiene el pelo de color " + Alumnos[alumno]["pelo"] + " y tiene " + str(Alumnos[alumno]["edad"]) + " años.")
                break
            elif opcion1 == 6:

                # Numero6: Muestra la edad media de los alumnos que van a inglés o a taekwondo (pero no a ambos) y son mayores de edad

                conj3 = set()
                for alumno in ingles:
                    if Alumnos[alumno]["edad"] >= 18:
                        conj3.add(Alumnos[alumno]["edad"])
                edad1 = round(sum(conj3) / len(conj3))
                print("La media de edad en los que son mayores de edad en ingles es: " + str(edad1) + ".")

                conj4 = set()
                for alumno in taekwondo:
                    if Alumnos[alumno]["edad"] >= 18:
                        conj4.add(Alumnos[alumno]["edad"])
                edad2 = round(sum(conj4) / len(conj4))
                print("La media de edad en los que son mayores de edad en ingles es: " + str(edad2) + ".")
                break
            elif opcion1 == 7:
                # Numero7 Muestra los nombres de los alumnos ordenados por edad de menor a mayor
                conj5 = []
                for alumno in Alumnos:
                    conj5.append((Alumnos[alumno]["edad"], alumno))
                conj5 = sorted(conj5)
                for edad, alumno in conj5:
                    print(alumno)

    elif opcion == 2:
        v1 = int(input("Valor minimo del rango--> "))
        v2 = int(input("Valor maximo del rango--> "))
        nv = int(input("Numero de valores--> "))

        print(sorted(funcion_aleatorio(v1, v2, nv)))
        break
    elif opcion == 3:
        print(listas_aleatorias())
        break
    elif opcion == 4:

        print("_" * 34)
        funcion_bonita(listas_aleatorias())
        print("-" * 34)
        break
    elif opcion == 5:
        num_ale = num_rand()
        print("El numero aleatorio es: " + str(num_ale) + ".")
        print("_" * 34)
        funcion_bonita(cambiar_num(listas_aleatorias(), num_ale))
        print("-" * 34)


