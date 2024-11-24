import csv

with open('empleados.csv', mode='r') as archivo:
    lector = csv.DictReader(archivo, delimiter=';')
    empleados = []
    for fila in lector:
        # Convertir salario y edad a valores numéricos
        fila['salario'] = float(fila['Salario'])
        fila['edad'] = int(fila['Edad'])
        empleados.append(fila)

#Calcular salario promedio
total_salarios = sum(empleado['salario'] for empleado in empleados)
promedio = total_salarios / len(empleados)
print(f"Salario promedio de todos los empleados: {promedio:.2f}")

#Trabajador que más cobra
max_salario = max(empleado['salario'] for empleado in empleados)
trabajadores_max_cobro = [empleado for empleado in empleados if empleado['salario'] == max_salario]
print("Trabajador(es) que más cobra(n):")
for empleado in trabajadores_max_cobro:
    print(f"{empleado['Nombre']} {empleado['Apellido']} - Salario: {empleado['salario']}")

#Trabajador que menos cobra
min_salario = min(empleado['salario'] for empleado in empleados)
trabajadores_min_cobro = [empleado for empleado in empleados if empleado['salario'] == min_salario]
print("Trabajador(es) que menos cobra(n):")
for empleado in trabajadores_min_cobro:
    print(f"{empleado['Nombre']} {empleado['Apellido']} - Salario: {empleado['salario']}")

#Empleados ordenados por edad (de mayor a menor)
empleados_ordenados = sorted(empleados, key=lambda x: x['edad'], reverse=True)
print("Empleados ordenados por edad (de mayor a menor):")
for empleado in empleados_ordenados:
    print(f"{empleado['Nombre']} {empleado['Apellido']} - Edad: {empleado['edad']}")
