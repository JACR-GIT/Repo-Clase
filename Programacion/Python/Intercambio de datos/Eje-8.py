"""Ejercicio 8: Organizador de Cursos (Extendido)
Crea un archivo cursos.json con esta estructura ampliada:
{
"academia": "Programadores Avanzados",
"cursos": [
{
"nombre": "Python Básico",
"duracion": "6 semanas",
"temas": ["variables", "listas", "condicionales"]
},
{
"nombre": "Python Avanzado",
"duracion": "8 semanas",
"temas": ["POO", "expresiones regulares",
"decoradores"]
},
{
"nombre": "Desarrollo Web",
"duracion": "10 semanas",
"temas": ["HTML", "CSS", "JavaScript"]
},
{
"nombre": "Análisis de Datos",
"duracion": "12 semanas",
"temas": ["pandas", "numpy", "visualización"]
},
{
"nombre": "Inteligencia Artificial",
"duracion": "14 semanas",
"temas": ["machine learning", "deep learning",
"procesamiento de lenguaje natural"]
},
{
"nombre": "Ciberseguridad",
"duracion": "10 semanas",
"temas": ["criptografía", "redes seguras", "seguridad
en aplicaciones"]
}
]
}
Posteriormente:
1. Imprime los nombres de todos los cursos con su duración.
2. Busca cursos que contengan más de 3 temas y muestra sus detalles."""

import json

# Cargar el archivo JSON
with open("cursos.json", "r") as file:
    data = json.load(file)

# Imprimir los nombres de todos los cursos con su duración
for curso in data["cursos"]:
    print(f"Curso: {curso['nombre']}, Duración: {curso['duracion']}")

# Buscar cursos con más de 3 temas
for curso in data["cursos"]:
    if len(curso["temas"]) > 3:
        print(f"Curso: {curso['nombre']}")
        print(f"Duración: {curso['duracion']}")
        print(f"Temas: {', '.join(curso['temas'])}")
        print("-" * 30)
