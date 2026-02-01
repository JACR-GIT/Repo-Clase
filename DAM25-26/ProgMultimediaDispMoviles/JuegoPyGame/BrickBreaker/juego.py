import pygame
import sys
import random

pygame.init()
pygame.mixer.init()

# -------------------------------
# CONSTANTES BASE (DIMENSIONES Y VALORES INICIALES)
# -------------------------------
ANCHO_BASE = 1920
ALTO_BASE = 1080
ANCHO_PALA_BASE = 200
ALTO_PALA_BASE = 20
MARGEN_INFERIOR_PALA_BASE = 50
TAMANO_BOLA_BASE = 20
ALTO_LADRILLO_BASE = 40
MARGEN_LATERAL_PORCENTAJE = 0.05
MARGEN_SUPERIOR_BASE = 80
ESPACIADO_HORIZONTAL_PORCENTAJE = 0.015
ESPACIADO_VERTICAL_BASE = 10
FILAS_LADRILLOS = 6
TAMANO_POWERUP_BASE = 40
VELOCIDAD_PALA_BASE = 15
TAMANO_FUENTE_GRANDE_BASE = 72
TAMANO_FUENTE_MEDIANA_BASE = 48
TAMANO_FUENTE_PEQUENA_BASE = 36
VELOCIDAD_CAIDA_POWERUP_BASE = 3.0
GRAVEDAD_POWERUP_BASE = 0.15

# -------------------------------
# COLORES
# -------------------------------
NEGRO = (0, 0, 0)
BLANCO = (255, 255, 255)
ROJO = (255, 0, 0)
AZUL = (0, 0, 255)
VERDE = (0, 255, 0)
AMARILLO = (255, 255, 0)
AZUL_OSCURO = (0, 50, 100)
GRIS_TRANSPARENTE = (30, 30, 50, 180)

# -------------------------------
# CONFIGURACION DE PANTALLA (FULLSCREEN NATIVO)
# -------------------------------
informacion_pantalla = pygame.display.Info()
ANCHO_PANTALLA = informacion_pantalla.current_w
ALTO_PANTALLA = informacion_pantalla.current_h
pantalla = pygame.display.set_mode((ANCHO_PANTALLA, ALTO_PANTALLA), pygame.FULLSCREEN)
pygame.display.set_caption("Power Brick Breaker - José Antonio")

# -------------------------------
# FUNCIONES DE ESCALADO RESPONSIVE
# -------------------------------
def obtener_escala_x():
    return ANCHO_PANTALLA / ANCHO_BASE

def obtener_escala_y():
    return ALTO_PANTALLA / ALTO_BASE

def obtener_escala_velocidad():
    return min(obtener_escala_x(), obtener_escala_y())

def obtener_fuente(tamano_base):
    return pygame.font.Font(None, int(tamano_base * obtener_escala_velocidad()))

def calcular_columnas():
    escala_x = obtener_escala_x()
    margen_x = MARGEN_LATERAL_PORCENTAJE * ANCHO_PANTALLA
    espaciado_x = ESPACIADO_HORIZONTAL_PORCENTAJE * ANCHO_PANTALLA
    ancho_ladrillo_base = 150 * escala_x
    columnas = max(8, min(14, int((ANCHO_PANTALLA - 2 * margen_x) / (ancho_ladrillo_base + espaciado_x))))
    return columnas

def generar_ladrillos():
    global lista_ladrillos
    escala_x = obtener_escala_x()
    escala_y = obtener_escala_y()
    columnas = calcular_columnas()
    margen_x = MARGEN_LATERAL_PORCENTAJE * ANCHO_PANTALLA
    margen_y = MARGEN_SUPERIOR_BASE * escala_y
    ancho_ladrillo = (ANCHO_PANTALLA - 2 * margen_x - (columnas - 1) * ESPACIADO_HORIZONTAL_PORCENTAJE * ANCHO_PANTALLA) / columnas
    alto_ladrillo = ALTO_LADRILLO_BASE * escala_y
    espaciado_y = ESPACIADO_VERTICAL_BASE * escala_y
    lista_ladrillos = []
    for j in range(FILAS_LADRILLOS):
        for i in range(columnas):
            x = margen_x + i * (ancho_ladrillo + ESPACIADO_HORIZONTAL_PORCENTAJE * ANCHO_PANTALLA)
            y = margen_y + j * (alto_ladrillo + espaciado_y)
            lista_ladrillos.append(pygame.Rect(x, y, ancho_ladrillo, alto_ladrillo))

def reiniciar_pala():
    global pala, velocidad_pala
    escala_x = obtener_escala_x()
    escala_y = obtener_escala_y()
    pala = pygame.Rect(ANCHO_PANTALLA // 2 - ANCHO_PALA_BASE * escala_x // 2,
                       ALTO_PANTALLA - MARGEN_INFERIOR_PALA_BASE * escala_y,
                       ANCHO_PALA_BASE * escala_x, ALTO_PALA_BASE * escala_y)
    velocidad_pala = VELOCIDAD_PALA_BASE * escala_x
    pala.clamp_ip(pantalla.get_rect())

# -------------------------------
# INICIALIZACION DE OBJETOS DEL JUEGO
# -------------------------------
pala = None
velocidad_pala = 0
lista_bolas = []
lista_ladrillos = []
lista_powerups = []
dedo_activo = None
posicion_dedo_anterior = None

# -------------------------------
# CARGA DE SONIDOS
# -------------------------------
try:
    sonido_rebote = pygame.mixer.Sound("Bounce.mp3")
    sonido_romper = pygame.mixer.Sound("Break.wav")
    sonido_gameover = pygame.mixer.Sound("GameOver.wav")
except:
    sonido_rebote = sonido_romper = sonido_gameover = None

# -------------------------------
# VARIABLES DEL ESTADO DEL JUEGO
# -------------------------------
puntuacion = 0
vidas = 3
nivel = 1
velocidad_base_bola = 5.0
temporizador_agrandar = 0
temporizador_lento = 0
estado_juego = 'menu'
reloj = pygame.time.Clock()

# -------------------------------
# FUNCIONES DE CONTROL DEL JUEGO
# -------------------------------
def reiniciar_juego():
    global puntuacion, vidas, nivel, velocidad_base_bola, temporizador_agrandar, temporizador_lento, lista_bolas, lista_ladrillos, lista_powerups, pala, velocidad_pala, dedo_activo, posicion_dedo_anterior
    puntuacion = 0
    vidas = 3
    nivel = 1
    velocidad_base_bola = 10.0
    temporizador_agrandar = 0
    temporizador_lento = 0
    dedo_activo = None
    posicion_dedo_anterior = None
    reiniciar_pala()
    escala_velocidad = obtener_escala_velocidad()
    tamano_bola = TAMANO_BOLA_BASE * escala_velocidad
    lista_bolas = [{'rect': pygame.Rect(ANCHO_PANTALLA // 2 - tamano_bola // 2, ALTO_PANTALLA // 2, tamano_bola, tamano_bola),
                    'velocidad': [random.choice([-velocidad_base_bola, velocidad_base_bola]) * escala_velocidad,
                                  -velocidad_base_bola * escala_velocidad]}]
    generar_ladrillos()
    lista_powerups.clear()

# -------------------------------
# BUCLE PRINCIPAL DEL JUEGO
# -------------------------------
ejecutando = True
while ejecutando:
    rect_pantalla = pantalla.get_rect()
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            ejecutando = False
        elif evento.type == pygame.KEYDOWN:
            if evento.key == pygame.K_ESCAPE:
                if estado_juego == 'jugando':
                    estado_juego = 'pausa'
                elif estado_juego == 'pausa':
                    estado_juego = 'jugando'
                elif estado_juego in ['menu', 'game_over']:
                    ejecutando = False
            elif evento.key in (pygame.K_SPACE, pygame.K_RETURN):
                if estado_juego in ['menu', 'game_over']:
                    reiniciar_juego()
                    estado_juego = 'jugando'
            elif estado_juego == 'pausa':
                if evento.key == pygame.K_c:
                    estado_juego = 'jugando'
                elif evento.key == pygame.K_r:
                    reiniciar_juego()
                    estado_juego = 'jugando'
                elif evento.key == pygame.K_m:
                    estado_juego = 'menu'
        elif evento.type == pygame.FINGERDOWN:
            if dedo_activo is None:
                dedo_activo = evento.finger_id
                posicion_dedo_anterior = evento.x * ANCHO_PANTALLA
                objetivo_x = evento.x * ANCHO_PANTALLA - pala.width // 2
                pala.centerx = max(pala.width // 2, min(ANCHO_PANTALLA - pala.width // 2, objetivo_x))
                pala.clamp_ip(rect_pantalla)
        elif evento.type == pygame.FINGERMOTION:
            if dedo_activo is not None and evento.finger_id == dedo_activo:
                posicion_actual = evento.x * ANCHO_PANTALLA
                if posicion_dedo_anterior is not None:
                    delta_x = posicion_actual - posicion_dedo_anterior
                    pala.move_ip(delta_x, 0)
                    pala.clamp_ip(rect_pantalla)
                posicion_dedo_anterior = posicion_actual
        elif evento.type == pygame.FINGERUP:
            if dedo_activo is not None and evento.finger_id == dedo_activo:
                dedo_activo = None
                posicion_dedo_anterior = None
        elif evento.type == pygame.MOUSEMOTION or evento.type == pygame.MOUSEBUTTONDOWN:
            if pygame.mouse.get_pressed()[0]:
                mouse_x = pygame.mouse.get_pos()[0]
                pala.centerx = max(pala.width // 2, min(ANCHO_PANTALLA - pala.width // 2, mouse_x))
                pala.clamp_ip(rect_pantalla)

    # -------------------------------
    # LÓGICA DEL JUEGO
    # -------------------------------
    if estado_juego == 'jugando':
        escala_velocidad = obtener_escala_velocidad()
        if temporizador_agrandar > 0:
            temporizador_agrandar -= 1
            if temporizador_agrandar == 0:
                pala.width = int(ANCHO_PALA_BASE * obtener_escala_x())
        if temporizador_lento > 0:
            temporizador_lento -= 1

        multiplicador_velocidad = 1 if temporizador_lento > 0 else 1.0

        for bola in lista_bolas[:]:
            bola['rect'].move_ip(bola['velocidad'][0] * multiplicador_velocidad, bola['velocidad'][1] * multiplicador_velocidad)
            bola['rect'].clamp_ip(rect_pantalla)

            if bola['rect'].left <= 0 or bola['rect'].right >= ANCHO_PANTALLA:
                bola['velocidad'][0] = -bola['velocidad'][0]
                if sonido_rebote: sonido_rebote.play()
            if bola['rect'].top <= 0:
                bola['velocidad'][1] = -bola['velocidad'][1]
                if sonido_rebote: sonido_rebote.play()

            if bola['rect'].bottom >= ALTO_PANTALLA:
                lista_bolas.remove(bola)
                if not lista_bolas:
                    vidas -= 1
                    if vidas == 0:
                        estado_juego = 'game_over'
                        if sonido_gameover: sonido_gameover.play()
                    else:
                        tamano_bola = TAMANO_BOLA_BASE * escala_velocidad
                        nueva_bola = {'rect': pygame.Rect(ANCHO_PANTALLA // 2 - tamano_bola // 2, ALTO_PANTALLA // 2, tamano_bola, tamano_bola),
                                      'velocidad': [random.choice([-velocidad_base_bola, velocidad_base_bola]) * escala_velocidad,
                                                    -velocidad_base_bola * escala_velocidad]}
                        lista_bolas = [nueva_bola]

            if bola['rect'].colliderect(pala):
                bola['velocidad'][1] = -abs(bola['velocidad'][1])
                if sonido_rebote: sonido_rebote.play()

        for bola in lista_bolas:
            for ladrillo in lista_ladrillos[:]:
                if bola['rect'].colliderect(ladrillo):
                    bola['velocidad'][1] = -bola['velocidad'][1]
                    lista_ladrillos.remove(ladrillo)
                    puntuacion += 10 * nivel
                    if sonido_romper: sonido_romper.play()
                    if random.randint(1, 4) == 1:
                        escala_velocidad = obtener_escala_velocidad()
                        px = ladrillo.centerx - TAMANO_POWERUP_BASE * escala_velocidad / 2
                        pu_rect = pygame.Rect(px, ladrillo.top, TAMANO_POWERUP_BASE * escala_velocidad, TAMANO_POWERUP_BASE * escala_velocidad)
                        tipo_pu = random.choice(['agrandar', 'multi', 'lento'])
                        lista_powerups.append({'rect': pu_rect, 'tipo': tipo_pu})
                    break

        if not lista_ladrillos:
            puntuacion += 200 * nivel
            velocidad_anterior = velocidad_base_bola
            velocidad_base_bola *= 1.08
            for b in lista_bolas:
                b['velocidad'][0] *= velocidad_base_bola / velocidad_anterior
                b['velocidad'][1] *= velocidad_base_bola / velocidad_anterior
            nivel += 1
            generar_ladrillos()

        for pu in lista_powerups[:]:
            distancia_caida = ALTO_PANTALLA - pu['rect'].top
            velocidad_caida = VELOCIDAD_CAIDA_POWERUP_BASE * escala_velocidad + GRAVEDAD_POWERUP_BASE * (distancia_caida / ALTO_PANTALLA) * escala_velocidad
            pu['rect'].move_ip(0, velocidad_caida)
            if pu['rect'].top > ALTO_PANTALLA:
                lista_powerups.remove(pu)

        for pu in lista_powerups[:]:
            if pu['rect'].colliderect(pala):
                lista_powerups.remove(pu)
                escala_x = obtener_escala_x()
                escala_velocidad = obtener_escala_velocidad()
                if pu['tipo'] == 'agrandar':
                    pala.width = int(ANCHO_PALA_BASE * escala_x * 1.5)
                    temporizador_agrandar = 300
                elif pu['tipo'] == 'multi' and len(lista_bolas) < 4:
                    tamano_bola = TAMANO_BOLA_BASE * escala_velocidad
                    nueva_bola = {'rect': pygame.Rect(pala.centerx - tamano_bola // 2, pala.top - tamano_bola, tamano_bola, tamano_bola),
                                  'velocidad': [random.choice([-velocidad_base_bola * 0.7, velocidad_base_bola * 0.7]) * escala_velocidad,
                                                -velocidad_base_bola * 1.3 * escala_velocidad]}
                    lista_bolas.append(nueva_bola)
                elif pu['tipo'] == 'lento':
                    temporizador_lento = 300

    # -------------------------------
    # DIBUJADO SEGUN ESTADO
    # -------------------------------
    pantalla.fill(NEGRO)

    if estado_juego == 'menu':
        fuente_titulo = obtener_fuente(TAMANO_FUENTE_GRANDE_BASE)
        fuente_mediana = obtener_fuente(TAMANO_FUENTE_MEDIANA_BASE)
        titulo = fuente_titulo.render("POWER BRICK BREAKER", True, BLANCO)
        rect_titulo = titulo.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 3))
        pantalla.blit(titulo, rect_titulo)
        texto_jugar = fuente_mediana.render("JUGAR (ESPACIO / ENTER)", True, VERDE)
        rect_jugar = texto_jugar.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2))
        pantalla.blit(texto_jugar, rect_jugar)
        texto_salir = fuente_mediana.render("SALIR (ESC)", True, ROJO)
        rect_salir = texto_salir.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2 + 100 * obtener_escala_y()))
        pantalla.blit(texto_salir, rect_salir)
        autor = obtener_fuente(TAMANO_FUENTE_PEQUENA_BASE).render("Por José Antonio - DAM 2025-26", True, BLANCO)
        pantalla.blit(autor, (20, ALTO_PANTALLA - 50))

    elif estado_juego in ['jugando', 'pausa']:
        pygame.draw.rect(pantalla, AZUL, pala)
        for bola in lista_bolas:
            pygame.draw.ellipse(pantalla, BLANCO, bola['rect'])
        for ladrillo in lista_ladrillos:
            pygame.draw.rect(pantalla, ROJO, ladrillo)
        for pu in lista_powerups:
            color = {'agrandar': ROJO, 'multi': VERDE, 'lento': AMARILLO}[pu['tipo']]
            pygame.draw.rect(pantalla, color, pu['rect'])

        fuente_ui = obtener_fuente(TAMANO_FUENTE_MEDIANA_BASE)
        texto_puntuacion = fuente_ui.render(f"Puntuación: {puntuacion}", True, BLANCO)
        pantalla.blit(texto_puntuacion, (20 * obtener_escala_x(), 20 * obtener_escala_y()))
        texto_nivel = fuente_ui.render(f"Nivel: {nivel}", True, BLANCO)
        pantalla.blit(texto_nivel, (20 * obtener_escala_x(), 70 * obtener_escala_y()))
        texto_vidas = fuente_ui.render(f"Vidas: {vidas}", True, BLANCO)
        pantalla.blit(texto_vidas, (ANCHO_PANTALLA - 250 * obtener_escala_x(), 20 * obtener_escala_y()))

        if estado_juego == 'pausa':
            superposicion = pygame.Surface((ANCHO_PANTALLA, ALTO_PANTALLA), pygame.SRCALPHA)
            superposicion.fill(GRIS_TRANSPARENTE)
            pantalla.blit(superposicion, (0, 0))

            fuente_mediana = obtener_fuente(TAMANO_FUENTE_MEDIANA_BASE)
            texto_pausa = fuente_mediana.render("PAUSA", True, BLANCO)
            rect_pausa = texto_pausa.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 3))
            pantalla.blit(texto_pausa, rect_pausa)

            texto_continuar = fuente_mediana.render("Continuar (C o ESC)", True, VERDE)
            rect_continuar = texto_continuar.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2 - 40 * obtener_escala_y()))
            pantalla.blit(texto_continuar, rect_continuar)

            texto_reiniciar = fuente_mediana.render("Reiniciar (R)", True, AMARILLO)
            rect_reiniciar = texto_reiniciar.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2 + 20 * obtener_escala_y()))
            pantalla.blit(texto_reiniciar, rect_reiniciar)

            texto_menu = fuente_mediana.render("Volver al menú (M)", True, ROJO)
            rect_menu = texto_menu.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2 + 80 * obtener_escala_y()))
            pantalla.blit(texto_menu, rect_menu)

    elif estado_juego == 'game_over':
        superposicion = pygame.Surface((ANCHO_PANTALLA, ALTO_PANTALLA))
        superposicion.set_alpha(128)
        superposicion.fill(AZUL_OSCURO)
        pantalla.blit(superposicion, (0, 0))

        fuente_titulo = obtener_fuente(TAMANO_FUENTE_GRANDE_BASE)
        fuente_mediana = obtener_fuente(TAMANO_FUENTE_MEDIANA_BASE)

        titulo_gameover = fuente_titulo.render("GAME OVER", True, ROJO)
        rect_titulo = titulo_gameover.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 3))
        pantalla.blit(titulo_gameover, rect_titulo)

        puntuacion_final = fuente_mediana.render(f"Puntuación Final: {puntuacion}", True, BLANCO)
        rect_puntuacion = puntuacion_final.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2 - 50 * obtener_escala_y()))
        pantalla.blit(puntuacion_final, rect_puntuacion)

        nivel_final = fuente_mediana.render(f"Nivel Alcanzado: {nivel}", True, BLANCO)
        rect_nivel = nivel_final.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2))
        pantalla.blit(nivel_final, rect_nivel)

        texto_reiniciar = fuente_mediana.render("REINICIAR (ESPACIO / ENTER)", True, VERDE)
        rect_reiniciar = texto_reiniciar.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2 + 80 * obtener_escala_y()))
        pantalla.blit(texto_reiniciar, rect_reiniciar)

        texto_salir = fuente_mediana.render("SALIR (ESC)", True, ROJO)
        rect_salir = texto_salir.get_rect(center=(ANCHO_PANTALLA // 2, ALTO_PANTALLA // 2 + 180 * obtener_escala_y()))
        pantalla.blit(texto_salir, rect_salir)

    pygame.display.flip()
    reloj.tick(60)

pygame.quit()
sys.exit()