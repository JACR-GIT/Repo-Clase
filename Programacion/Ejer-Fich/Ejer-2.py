with open("usuario.txt" , "a") as f:
    entrada = input("Introduce un nombre y apellido (o dejalo vacio para salir) : ").strip()
    if entrada == "":
        print("No se introduce un nombre y apellido. ")
    else:
        f.write(entrada + "\n")
        print("El nombre " + str(entrada) + " se ha guardado")