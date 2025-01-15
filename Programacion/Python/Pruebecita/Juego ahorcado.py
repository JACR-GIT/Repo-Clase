from Ahorcado import iniciaAhorcado
categoria, adivinaOriginal, adivinaLower, adivinaOculto = iniciaAhorcado()
def juegaAhorcado():
    categoria, adivinaOriginal, adivinaLower, adivinaOculto = iniciaAhorcado()
    intentos = 6
    letrasIntentadas = set()

    print(f"¡Bienvenido al Ahorcado! La categoría es: {categoria}")
    print(f"Palabra a adivinar: {adivinaOculto}")

    while intentos > 0 and '_' in adivinaOculto:
        letra = input("Adivina una letra: ").lower()

        # Validar si ya se intentó esta letra
        if letra in letrasIntentadas:
            print("Ya intentaste esa letra. Prueba otra.")
            continue

        letrasIntentadas.add(letra)

        if letra in adivinaLower:
            # Actualizar adivinaOculto con la letra acertada
            adivinaOculto = ''.join(
                letra if adivinaLower[i] == letra else adivinaOculto[i]
                for i in range(len(adivinaLower))
            )
            print(f"¡Bien! {adivinaOculto}")
        else:
            intentos -= 1
            print(f"Letra incorrecta. Te quedan {intentos} intentos.")

    if '_' not in adivinaOculto:
        print(f"¡Felicidades! Adivinaste la palabra: {adivinaOriginal}")
    else:
        print(f"Lo siento, te quedaste sin intentos. La palabra era: {adivinaOriginal}")


# Ejecutar el juego
juegaAhorcado()
