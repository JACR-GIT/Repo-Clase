# Diccionario de datos: Pokédex
pokedex = {
    1: {"nombre_es": "Bulbasaur", "nombre_jp": "Fushigidane", "tipo": ["Planta", "Veneno"], "evolucion": [2]},
    5: {"nombre_es": "Charmeleon", "nombre_jp": "Lizardo", "tipo": ["Fuego"], "evolucion": [6]},
    6: {"nombre_es": "Charizard", "nombre_jp": "Lizardon", "tipo": ["Fuego", "Volador"], "evolucion": None},
    79: {"nombre_es": "Slowpoke", "nombre_jp": "Yadon", "tipo": ["Agua", "Psíquico"], "evolucion": [80, 199]},
    80: {"nombre_es": "Slowbro", "nombre_jp": "Yadoran", "tipo": ["Agua", "Psíquico"], "evolucion": None},
    199: {"nombre_es": "Slowking", "nombre_jp": "Yadoking", "tipo": ["Agua", "Psíquico"], "evolucion": None},
    133: {"nombre_es": "Eevee", "nombre_jp": "Eievui", "tipo": ["Normal"], "evolucion": [134, 135, 136, 196, 197, 470, 471, 700]},
    134: {"nombre_es": "Vaporeon", "nombre_jp": "Showers", "tipo": ["Agua"], "evolucion": None},
    135: {"nombre_es": "Jolteon", "nombre_jp": "Thunders", "tipo": ["Eléctrico"], "evolucion": None},
    136: {"nombre_es": "Flareon", "nombre_jp": "Booster", "tipo": ["Fuego"], "evolucion": None},
    196: {"nombre_es": "Espeon", "nombre_jp": "Eifie", "tipo": ["Psíquico"], "evolucion": None},
    197: {"nombre_es": "Umbreon", "nombre_jp": "Blacky", "tipo": ["Siniestro"], "evolucion": None},
    470: {"nombre_es": "Leafeon", "nombre_jp": "Leafia", "tipo": ["Planta"], "evolucion": None},
    471: {"nombre_es": "Glaceon", "nombre_jp": "Glacia", "tipo": ["Hielo"], "evolucion": None},
    700: {"nombre_es": "Sylveon", "nombre_jp": "Nymphia", "tipo": ["Hada"], "evolucion": None},
    802: {"nombre_es": "Marshadow", "nombre_jp": "Marshadow", "tipo": ["Lucha", "Fantasma"], "evolucion": [803]},
    376: {"nombre_es": "Metagross", "nombre_jp": "Metagross", "tipo": ["Acero", "Psíquico"], "evolucion": None},
    593: {"nombre_es": "Jellicent", "nombre_jp": "Burungel", "tipo": ["Agua", "Fantasma"], "evolucion": None},
}

# Funciones para resolver los ejercicios

def listar_pokemon():
    """Imprime los nombres en español de todos los Pokémon."""
    print("\nPokémon en la Pokédex:")
    for datos in pokedex.values():
        print(datos["nombre_es"])

def filtrar_por_tipo(tipo):
    """Imprime una lista de Pokémon que tienen el tipo especificado."""
    tipo = tipo.lower()  # Convertir el tipo ingresado a minúsculas
    print(f"\nPokémon de tipo {tipo}:")
    for datos in pokedex.values():
        # Verificar si el tipo en minúsculas está en la lista de tipos
        if tipo in [t.lower() for t in datos["tipo"]]:
            print(datos["nombre_es"])

def contar_pokemon_por_tipo():
    """Cuenta cuántos Pokémon hay por cada tipo."""
    tipos = {}
    for datos in pokedex.values():
        for tipo in datos["tipo"]:
            tipos[tipo] = tipos.get(tipo, 0) + 1
    print("\nCantidad de Pokémon por tipo:")
    for tipo, cantidad in tipos.items():
        print(f"{tipo}: {cantidad}")

def buscar_evoluciones(id_pokemon):
    """Busca e imprime las evoluciones de un Pokémon dado su ID."""
    if id_pokemon in pokedex:
        datos = pokedex[id_pokemon]
        print(f"\n{datos['nombre_es']} evoluciona a:")
        if datos["evolucion"]:
            for evolucion in datos["evolucion"]:
                if evolucion in pokedex:
                    print(f"- {pokedex[evolucion]['nombre_es']}")
        else:
            print("Este Pokémon no tiene evoluciones.")
    else:
        print("ID de Pokémon no encontrado.")

def pokemon_sin_evoluciones():
    """Imprime los nombres de los Pokémon que no tienen evoluciones."""
    print("\nPokémon sin evoluciones:")
    for datos in pokedex.values():
        if not datos["evolucion"]:
            print(datos["nombre_es"])

def arbol_de_evoluciones(id_pokemon):
    """Muestra toda la cadena de evoluciones de un Pokémon."""
    def buscar_cadena(id_pokemon, nivel=0):
        if id_pokemon in pokedex:
            datos = pokedex[id_pokemon]
            print("  " * nivel + f"- {datos['nombre_es']}")
            if datos["evolucion"]:
                for evolucion in datos["evolucion"]:
                    buscar_cadena(evolucion, nivel + 1)

    print(f"\nCadena evolutiva para el ID {id_pokemon}:")
    buscar_cadena(id_pokemon)

def clasificar_por_tipos():
    """Ordena los Pokémon según la cantidad de tipos que tienen."""
    print("\nPokémon clasificados por cantidad de tipos:")
    clasificados = sorted(pokedex.values(), key=lambda x: len(x["tipo"]))
    for datos in clasificados:
        print(f"{datos['nombre_es']} ({len(datos['tipo'])} tipos)")

def mostrar_nombres_por_idioma(idioma):
    """Muestra los nombres de los Pokémon según el idioma ('es' o 'jp')."""
    print(f"\nNombres de los Pokémon en {idioma}:")
    clave = f"nombre_{idioma}"
    for datos in pokedex.values():
        if clave in datos:
            print(datos[clave])

def agregar_pokemon(id_pokemon, nombre_es, nombre_jp, tipos, evoluciones):
    """Agrega un nuevo Pokémon al diccionario."""
    if id_pokemon in pokedex:
        print("ID ya existe en la Pokédex.")
    else:
        pokedex[id_pokemon] = {
            "nombre_es": nombre_es,
            "nombre_jp": nombre_jp,
            "tipo": tipos,
            "evolucion": evoluciones
        }
        print(f"{nombre_es} ha sido agregado a la Pokédex.")

def actualizar_evoluciones(id_pokemon):
    """Actualiza la lista de evoluciones de un Pokémon dado su ID."""
    if id_pokemon in pokedex:
        nuevos_evoluciones = input("Ingrese las nuevas evoluciones separadas por comas (o deje vacío para eliminar): ")
        if nuevos_evoluciones:
            nuevos_evoluciones = [int(e) for e in nuevos_evoluciones.split(",")]
        else:
            nuevos_evoluciones = None

        pokedex[id_pokemon]['evolucion'] = nuevos_evoluciones
        print(f"Evoluciones de {pokedex[id_pokemon]['nombre_es']} actualizadas.")
    else:
        print("ID de Pokémon no encontrado.")

def eliminar_pokemon(id_pokemon):
    """Elimina un Pokémon del diccionario y ajusta las cadenas evolutivas de otros Pokémon."""
    if id_pokemon in pokedex:
        # Eliminar el Pokémon de la Pokédex
        nombre = pokedex[id_pokemon]['nombre_es']
        for datos in pokedex.values():
            if datos['evolucion'] and id_pokemon in datos['evolucion']:
                datos['evolucion'].remove(id_pokemon)

        del pokedex[id_pokemon]
        print(f"{nombre} ha sido eliminado de la Pokédex.")
    else:
        print("ID de Pokémon no encontrado.")

def buscar_pokemon_por_nombre(nombre):
    """Busca un Pokémon por su nombre en español o japonés."""
    encontrado = False
    for id_pokemon, datos in pokedex.items():
        if datos['nombre_es'].lower() == nombre.lower() or datos['nombre_jp'].lower() == nombre.lower():
            print(f"Encontrado: {datos['nombre_es']} (ID: {id_pokemon})")
            encontrado = True
            break
    if not encontrado:
        print("Pokémon no encontrado.")

def listar_pokemon_por_evolucion(id_pokemon):
    """Lista todos los Pokémon que evolucionan de un Pokémon dado su ID."""
    evolucionados = []
    if id_pokemon in pokedex:
        for datos in pokedex.values():
            if datos['evolucion'] and id_pokemon in datos['evolucion']:
                evolucionados.append(datos['nombre_es'])
        if evolucionados:
            print(f"Pokémon que evolucionan de {pokedex[id_pokemon]['nombre_es']}: {', '.join(evolucionados)}")
        else:
            print(f"{pokedex[id_pokemon]['nombre_es']} no tiene evoluciones.")
    else:
        print("ID de Pokémon no encontrado.")

def contar_pokemon_totales():
    """Cuenta el total de Pokémon en la Pokédex."""
    total = len(pokedex)
    print(f"Total de Pokémon en la Pokédex: {total}")

def listar_pokemon_por_rango(inicio, fin):
    """Lista Pokémon cuyo ID se encuentra en un rango específico."""
    print(f"Pokémon con ID entre {inicio} y {fin}:")
    for id_pokemon, datos in pokedex.items():
        if inicio <= id_pokemon <= fin:
            print(datos['nombre_es'])

def obtener_info_pokemon(id_pokemon):
    """Muestra información detallada sobre un Pokémon."""
    if id_pokemon in pokedex:
        datos = pokedex[id_pokemon]
        print(f"ID: {id_pokemon}")
        print(f"Nombre en español: {datos['nombre_es']}")
        print(f"Nombre en japonés: {datos['nombre_jp']}")
        print(f"Tipos: {', '.join(datos['tipo'])}")
        evoluciones = datos['evolucion'] if datos['evolucion'] else "Ninguna"
        print(f"Evoluciones: {evoluciones}")
    else:
        print("ID de Pokémon no encontrado.")

def filtrar_por_multiplos_tipos(tipos):
    """Filtra y muestra Pokémon que tengan todos los tipos especificados."""
    tipos = tipos.split(",")
    print(f"\nPokémon con tipos: {', '.join(tipos)}:")
    for datos in pokedex.values():
        if all(tipo in datos['tipo'] for tipo in tipos):
            print(datos['nombre_es'])

def menu():
    """Menú principal para seleccionar los ejercicios."""
    while True:
        print("\n--- MENÚ ---")
        print("1. Listar Pokémon")
        print("2. Filtrar por tipo")
        print("3. Contar Pokémon por tipo")
        print("4. Buscar evoluciones")
        print("5. Pokémon sin evoluciones")
        print("6. Árbol de evoluciones")
        print("7. Clasificar por número de tipos")
        print("8. Mostrar nombres por idioma")
        print("9. Agregar Pokémon")
        print("10. Actualizar evoluciones")
        print("11. Eliminar Pokémon")
        print("12. Buscar Pokémon por nombre")
        print("13. Listar Pokémon por evolución")
        print("14. Contar Pokémon totales")
        print("15. Listar Pokémon por rango de ID")
        print("16. Obtener información detallada de un Pokémon")
        print("17. Filtrar Pokémon por múltiples tipos")
        print("0. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            listar_pokemon()
        elif opcion == "2":
            tipo = input("Ingrese el tipo de Pokémon: ")
            filtrar_por_tipo(tipo)
        elif opcion == "3":
            contar_pokemon_por_tipo()
        elif opcion == "4":
            id_pokemon = int(input("Ingrese el ID del Pokémon: "))
            buscar_evoluciones(id_pokemon)
        elif opcion == "5":
            pokemon_sin_evoluciones()
        elif opcion == "6":
            id_pokemon = int(input("Ingrese el ID del Pokémon: "))
            arbol_de_evoluciones(id_pokemon)
        elif opcion == "7":
            clasificar_por_tipos()
        elif opcion == "8":
            idioma = input("Ingrese el idioma ('es' o 'jp'): ")
            mostrar_nombres_por_idioma(idioma)
        elif opcion == "9":
            id_pokemon = int(input("Ingrese el ID del nuevo Pokémon: "))
            nombre_es = input("Ingrese el nombre en español: ")
            nombre_jp = input("Ingrese el nombre en japonés: ")
            tipos = input("Ingrese los tipos separados por comas: ").split(",")
            evoluciones = input("Ingrese las evoluciones separadas por comas (o deje vacío si no tiene): ")
            evoluciones = [int(e) for e in evoluciones.split(",")] if evoluciones else None
            agregar_pokemon(id_pokemon, nombre_es, nombre_jp, tipos, evoluciones)
        elif opcion == "10":
            id_pokemon = int(input("Ingrese el ID del Pokémon cuyas evoluciones desea actualizar: "))
            actualizar_evoluciones(id_pokemon)
        elif opcion == "11":
            id_pokemon = int(input("Ingrese el ID del Pokémon que desea eliminar: "))
            eliminar_pokemon(id_pokemon)
        elif opcion == "12":
            nombre = input("Ingrese el nombre del Pokémon a buscar: ")
            buscar_pokemon_por_nombre(nombre)
        elif opcion == "13":
            id_pokemon = int(input("Ingrese el ID del Pokémon: "))
            listar_pokemon_por_evolucion(id_pokemon)
        elif opcion == "14":
            contar_pokemon_totales()
        elif opcion == "15":
            inicio = int(input("Ingrese el ID inicial: "))
            fin = int(input("Ingrese el ID final: "))
            listar_pokemon_por_rango(inicio, fin)
        elif opcion == "16":
            id_pokemon = int(input("Ingrese el ID del Pokémon: "))
            obtener_info_pokemon(id_pokemon)
        elif opcion == "17":
            tipos = input("Ingrese los tipos separados por comas: ")
            filtrar_por_multiplos_tipos(tipos)
        elif opcion == "0":
            print("¡Hasta luego!")
            break
        else:
            print("Opción no válida. Intente de nuevo.")

# Ejecutar el menú principal
menu()