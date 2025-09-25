import csv
def registrar_producto(producto, cantidad, precio):
    with open("inventario.csv", "a") as f:
        writer = csv.writer(f)
        writer.writerow([producto, cantidad, precio])

while True:
    producto = input("Introduce el nombre del producto (pulsa Enter para salir): ")
    if not producto:
        break
    cantidad = int(input("Introduce la cantidad: "))
    precio = float(input("Introduce el precio: "))
    registrar_producto(producto, cantidad, precio)