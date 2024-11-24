import datetime

def inicia_sesion():
    confirmacion = input("¿Desea iniciar sesión? (S/N): ")
    if confirmacion == "S":
        now = datetime.datetime.now()
        fecha_hora = now.strftime("%Y-%m-%d %H:%M:%S")
        with open("log.txt", "a") as f:
            f.write(fecha_hora + "\n")
    else:
        print("No se ha podido iniciar sesión.")

inicia_sesion()