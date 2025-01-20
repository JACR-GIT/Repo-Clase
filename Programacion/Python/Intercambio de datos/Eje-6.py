"""Ejercicio 6: Generar un JSON con Niveles Jerárquicos
1. Escribe un programa que solicite al usuario datos para un árbol genealógico,
incluyendo:
○ Nombre de la persona.
○ Edad.
○ Lista de hijos (nombre y edad de cada uno).
Genera un JSON jerárquico con esta estructura:
{
"nombre": "Juan",
"edad": 50,
"hijos": [
{
"nombre": "Ana",
"edad": 25
},
{
"nombre": "Luis",
"edad": 20
}
]
}
2.
3. Guarda el JSON en un archivo llamado arbol_genealogico.json.
4. Escribe un segundo programa que lea el archivo, deserialice el JSON y:
○ Imprima el nombre del padre y de todos los hijos.
○ Calcule e imprima el promedio de edad de los hijos."""

import json

# Paso 1: Solicitar datos al usuario
nombre_padre = input("Ingrese el nombre del padre/madre: ")
edad_padre = int(input("Ingrese la edad del padre/madre: "))

# Crear una lista para los hijos
hijos = []
cantidad_hijos = int(input("¿Cuántos hijos tiene? "))

for i in range(cantidad_hijos):
    print(f"--- Datos del hijo {i + 1} ---")
    nombre_hijo = input("Ingrese el nombre del hijo: ")
    edad_hijo = int(input("Ingrese la edad del hijo: "))
    hijos.append({"nombre": nombre_hijo, "edad": edad_hijo})

# Paso 2: Crear la estructura del árbol genealógico
arbol_genealogico = {
    "nombre": nombre_padre,
    "edad": edad_padre,
    "hijos": hijos
}

# Paso 3: Guardar el JSON en un archivo
with open("arbol_genealogico.json", "w") as archivo:
    json.dump(arbol_genealogico, archivo, indent=4)

print("El árbol genealógico se ha guardado en 'arbol_genealogico.json'.")



# Paso 1: Leer el archivo JSON
with open("arbol_genealogico.json", "r") as archivo:
    arbol_genealogico = json.load(archivo)

# Paso 2: Imprimir el nombre del padre/madre y de los hijos
print(f"Nombre del padre/madre: {arbol_genealogico['nombre']}")
print("Hijos:")
for hijo in arbol_genealogico["hijos"]:
    print(f"- {hijo['nombre']}, Edad: {hijo['edad']}")

# Paso 3: Calcular e imprimir el promedio de edad de los hijos
if arbol_genealogico["hijos"]:
    total_edades = sum(hijo["edad"] for hijo in arbol_genealogico["hijos"])
    promedio_edad = total_edades / len(arbol_genealogico["hijos"])
    print(f"Promedio de edad de los hijos: {promedio_edad:.2f} años")
else:
    print("No hay hijos registrados.")
