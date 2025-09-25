import os
if not os.path.exists("mi_directorio"):
    os.mkdir("mi_directorio")

if not os.path.exists("mi_directorio/registro.txt"):
    with open("mi_directorio/registro.txt", "w") as f:
        pass

with open("mi_directorio/registro.txt", "a") as f:
    f.write("Primera línea\n")
    f.write("Segunda línea\n")
    f.write("Tercera línea\n")