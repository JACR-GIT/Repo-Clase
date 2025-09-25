base = input('Introduce la base imponible de la factura: ')
iva = 21
def aplica_iva(base, iva):
    base = int(base) * int(iva)
    base = base / 100
    return base

print(aplica_iva(base, iva))
