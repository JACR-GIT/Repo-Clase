-- ============================================================
-- 1. USUARIOS
-- ============================================================
CREATE TABLE IF NOT EXISTS usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre_usuario VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100) NOT NULL,
    correo VARCHAR(150) UNIQUE NOT NULL,
    contrasena TEXT NOT NULL,
    edad INT,
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- ============================================================
-- 2. PRENDAS
-- ============================================================
CREATE TABLE IF NOT EXISTS prendas (
    id INT NOT NULL AUTO_INCREMENT,
    id_dueno INT NOT NULL,
    nombre_prenda VARCHAR(150) NOT NULL,
    descripcion TEXT,
    talla VARCHAR(20),
    categoria VARCHAR(50),
    condicion VARCHAR(50),
    -- imagenes JSON,
    disponible BOOLEAN DEFAULT TRUE,
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_prendas_dueno
        FOREIGN KEY (id_dueno) REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- ============================================================
-- 3. INTERCAMBIOS / PRÉSTAMOS
-- ============================================================
CREATE TABLE IF NOT EXISTS intercambios (
    id INT NOT NULL AUTO_INCREMENT,
    id_prenda INT NOT NULL,
    id_solicitante INT NOT NULL,
    id_dueno INT NOT NULL,
    tipo ENUM('intercambio','prestamo') NOT NULL,
    estado ENUM('pendiente','aceptado','rechazado','finalizado') DEFAULT 'pendiente',
    fecha_inicio DATE,
    fecha_fin DATE,
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_intercambio_prenda
        FOREIGN KEY (id_prenda) REFERENCES prendas(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_intercambio_solicitante
        FOREIGN KEY (id_solicitante) REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_intercambio_dueno
        FOREIGN KEY (id_dueno) REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- ============================================================
-- 4. CONVERSACIONES
-- ============================================================
CREATE TABLE IF NOT EXISTS conversaciones (
    id INT NOT NULL AUTO_INCREMENT,
    id_usuario1 INT NOT NULL,
    id_usuario2 INT NOT NULL,
    id_intercambio INT NOT NULL,
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_conv_usuario1
        FOREIGN KEY (id_usuario1) REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_conv_usuario2
        FOREIGN KEY (id_usuario2) REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_conv_intercambio
        FOREIGN KEY (id_intercambio) REFERENCES intercambios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- ============================================================
-- 5. MENSAJES
-- ============================================================
CREATE TABLE IF NOT EXISTS mensajes (
    id INT NOT NULL AUTO_INCREMENT,
    id_conversacion INT NOT NULL,
    id_remitente INT NOT NULL,
    contenido TEXT NOT NULL,
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_msg_conversacion
        FOREIGN KEY (id_conversacion) REFERENCES conversaciones(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_msg_remitente
        FOREIGN KEY (id_remitente) REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- ============================================================
-- 6. VALORACIONES / REPUTACIÓN
-- ============================================================
CREATE TABLE IF NOT EXISTS valoraciones (
    id INT NOT NULL AUTO_INCREMENT,
    id_valorador INT NOT NULL,
    id_valorado INT NOT null,
    puntuacion TINYINT NOT NULL CHECK (puntuacion BETWEEN 1 AND 5),
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_valorador
        FOREIGN KEY (id_valorador) REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_valorado
        FOREIGN KEY (id_valorado) REFERENCES usuarios(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

SELECT 
    p.id AS id_prenda,
    p.nombre_prenda,
    p.descripcion,
    p.talla,
    p.categoria,
    p.condicion,
    COUNT(i.id) AS total_intercambios
FROM prendas p
INNER JOIN intercambios i ON i.id_prenda = p.id
GROUP BY p.id
ORDER BY total_intercambios DESC
LIMIT 5;
