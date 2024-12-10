def es_primo(numero):
    """
    Determina si un número es primo o no.
    Un número es primo si es mayor que 1 y no es divisible por ningún número
    entre 2 y la raíz cuadrada de sí mismo.

    Args:
        numero (int): Número a verificar.

    Returns:
        bool: True si el número es primo, False en caso contrario.
    """
    if numero <= 1:
        return False

    for i in range(2, int(numero ** 0.5) + 1):
        if numero % i == 0:
            return False
    return True


def generar_primos(limite):
    """
    Genera una lista de números primos hasta un límite dado.

    Args:
        limite (int): El límite superior para generar números primos.

    Returns:
        list: Lista de números primos hasta el límite especificado.
    """
    primos = []
    for numero in range(2, limite + 1):
        if es_primo(numero):
            primos.append(numero)
    return primos


# Ejemplo de uso:
numero = 29
print(f"¿El número {numero} es primo? {es_primo(numero)}")

limite = 50
print(f"Números primos hasta {limite}: {generar_primos(limite)}")
