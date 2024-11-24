import csv

with open('empleados.csv', mode='r') as archivo:
    lector = csv.reader(archivo, delimiter=';')
    cabecera = next(lector)
    empleados = []

    for fila in lector:
        salario = float(fila[5])
        if salario < 40000:
            salario += salario * 0.10
        else:
            salario += salario * 0.05
        fila[5] = f"{salario:.2f}"
        empleados.append(fila)

with open('empleados_actualizado.csv', mode='w', newline='') as archivo_salida:
    escritor = csv.writer(archivo_salida, delimiter=';')
    escritor.writerow(cabecera)
    escritor.writerows(empleados)

print("Los salarios han sido actualizados y guardados en 'empleados_actualizado.csv'.")
