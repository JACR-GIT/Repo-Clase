"""11) Validación de IPs.
Comprueba si una dirección IP es válida (IPv4).
"""
import re
def validar_ip(ip):
    patron = r"^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"
    if re.match(patron, ip):
        return "IP valida"
    else:
        return "IP no valida"
print(validar_ip("192.178.0.1"))