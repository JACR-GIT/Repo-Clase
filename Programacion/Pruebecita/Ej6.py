def eliminar_vocales (cadena):
    vocales = "aeiouAEIOU"
    return ''.join([letra for letra in cadena if letra not in vocales])
cad1 = "Esta cadena tiene demasiadas vocales"
print(eliminar_vocales(cad1))