-- ============================================================
-- 0. BORRAR TODA LA BASE DE DATOS (OPCIONAL)
-- ============================================================
DROP TABLE IF EXISTS mensajes;
DROP TABLE IF EXISTS conversaciones;
DROP TABLE IF EXISTS valoraciones;
DROP TABLE IF EXISTS intercambios;
DROP TABLE IF EXISTS prendas;
DROP TABLE IF EXISTS usuarios;


ALTER TABLE prendas ADD COLUMN foto VARCHAR(500) NULL;
UPDATE prendas SET foto = 'https://m.media-amazon.com/images/I/51YrZfhoQmL._AC_UY1000_.jpg' WHERE id = 1;  -- Camiseta roja
UPDATE prendas SET foto = 'https://m.media-amazon.com/images/I/81rwAOfF4KL.jpg' WHERE id = 2;  -- Jeans azules
UPDATE prendas SET foto = 'https://m.media-amazon.com/images/S/aplus-media-library-service-media/8ff901c1-3c09-4f07-9e08-a36cd48a1768.__CR0,0,970,600_PT0_SX970_V1___.jpg' WHERE id = 3;  -- Vestido floral
UPDATE prendas SET foto = 'https://www.univision.com/_next/image?url=https%3A%2F%2Fuvn-brightspot.s3.amazonaws.com%2Fassets%2Fvixes%2Fc%2Fchamarra-de-piel-o-cuero-730571353.jpg&w=1280&q=75' WHERE id = 4;  -- Chaqueta cuero negra
UPDATE prendas SET foto = 'https://hips.hearstapps.com/hmg-prod/images/gettyimages-1513904489-68aebab132fb2.jpg' WHERE id = 5;  -- Zapatillas blancas
UPDATE prendas SET foto = 'https://m.media-amazon.com/images/S/aplus-media-library-service-media/9ab8c948-a95e-4d29-a1ae-2fcaaf558125.__CR0,0,1800,1350_PT0_SX600_V1___.jpg' WHERE id = 6;  -- Otra camiseta
UPDATE prendas SET foto = 'https://media.vogue.mx/photos/63eac0a418c9ac1a3d68c9f7/4:3/w_5618,h_4214,c_limit/mom-jeans-vogue-GettyImages-1397932708%20(1).jpg' WHERE id = 7;  -- Mom jeans
UPDATE prendas SET foto = 'https://m.media-amazon.com/images/S/aplus-media-library-service-media/df62736b-abf0-411d-b936-f6b66f8d03b5.__CR0,0,1200,900_PT0_SX600_V1___.jpg' WHERE id = 8;  -- Vestido verano
UPDATE prendas SET foto = 'https://media.glamour.mx/photos/61908d52a6e030d6480fd613/master/w_1600,c_limit/195996.jpg' WHERE id = 9;  -- Chaqueta piel
UPDATE prendas SET foto = 'https://e01-elmundo.uecdn.es/assets/multimedia/imagenes/2024/01/16/17054167971868.jpg' WHERE id = 10;  -- Zapatillas outfit
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
    fecha_nac DATE,                         
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
    estilo VARCHAR(30),
    condicion VARCHAR(50),
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
    id_prenda2 INT NULL,                    
    id_solicitante INT NOT NULL,
    id_dueno INT NOT NULL,
    tipo ENUM('INTERCAMBIO','PRESTAMO') NOT NULL,
    estado ENUM('PENDIENTE','ACEPTADO','RECHAZADO','FINALIZADO') DEFAULT 'PENDIENTE',
    fecha_inicio DATE,
    fecha_fin DATE,
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),

    CONSTRAINT fk_intercambio_prenda
        FOREIGN KEY (id_prenda) REFERENCES prendas(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_intercambio_prenda2
        FOREIGN KEY (id_prenda2) REFERENCES prendas(id)
        ON DELETE SET NULL
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
    id_valorado INT NOT NULL,
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

-- ============================================================
-- 1. USUARIOS (10 registros)
-- ============================================================
INSERT INTO usuarios (nombre_usuario, nombre, apellido1, apellido2, correo, contrasena, fecha_nac)
VALUES
('juanito12', 'Juan', 'Pérez', 'Gómez', 'juan@gmail.com', '123456', '1990-05-12'),
('maria23', 'María', 'López', 'Santos', 'maria@gmail.com', '123456', '1995-03-20'),
('carlos88', 'Carlos', 'Martín', 'Ruiz', 'carlos@gmail.com', '123456', '1988-11-02'),
('laura92', 'Laura', 'Sánchez', 'Díaz', 'laura@gmail.com', '123456', '1992-07-14'),
('pepe01', 'José', 'Ramírez', 'Torres', 'pepe@gmail.com', '123456', '1998-01-30'),
('ana77', 'Ana', 'Fernández', 'Rey', 'ana@gmail.com', '123456', '1977-10-10'),
('luis55', 'Luis', 'Gil', 'Mora', 'luis@gmail.com', '123456', '1999-09-09'),
('sofia44', 'Sofía', 'Vega', 'Castro', 'sofia@gmail.com', '123456', '2000-12-01'),
('roberto10', 'Roberto', 'Navarro', 'Delgado', 'roberto@gmail.com', '123456', '1980-06-22'),
('eva09', 'Eva', 'Romero', 'Flores', 'eva@gmail.com', '123456', '1994-04-17');


-- ============================================================
-- 2. PRENDAS (10 registros)
-- ============================================================
INSERT INTO prendas (id_dueno, nombre_prenda, descripcion, talla, categoria, estilo, condicion)
VALUES
(1, 'Camiseta Roja', 'Camiseta básica roja', 'M', 'ROPA','CASUAL', 'BUENA'),
(1, 'Pantalón Vaquero', 'Vaqueros azules', 'L', 'ROPA','CASUAL', 'EXCELENTE'),
(2, 'Sudadera Negra', 'Sudadera con capucha', 'M', 'ROPA','CASUAL', 'BUENA'),
(3, 'Chaqueta Cuero', 'Chaqueta estilo biker', 'L', 'ABRIGO','CASUAL', 'EXCELENTE'),
(4, 'Vestido Azul', 'Vestido elegante azul', 'S', 'ROPA','CASUAL', 'BUENA'),
(5, 'Zapatillas Nike', 'Zapatillas deportivas', '42', 'CALZADO','CASUAL', 'REGULAR'),
(6, 'Gorra Negra', 'Gorra deportiva ajustable', 'Única', 'ACCESORIO','CASUAL', 'BUENA'),
(7, 'Bolso Marrón', 'Bolso piel sintética', 'Única', 'ACCESORIO','CASUAL', 'EXCELENTE'),
(8, 'Falda Roja', 'Falda ajustada', 'S', 'ROPA','CASUAL', 'BUENA'),
(9, 'Polo Blanco', 'Polo algodón blanco', 'M', 'ROPA','CASUAL', 'BUENA');


-- ============================================================
-- 3. INTERCAMBIOS / PRÉSTAMOS (10 registros)
-- id_prenda2 puede ir NULL o definido
-- ============================================================
INSERT INTO intercambios (id_prenda, id_prenda2, id_solicitante, id_dueno, tipo, estado, fecha_inicio, fecha_fin)
VALUES
(1, NULL, 2, 1, 'prestamo', 'pendiente', '2024-01-01', NULL),
(2, 3, 3, 1, 'intercambio', 'aceptado', '2024-01-05', '2024-01-20'),
(3, NULL, 4, 2, 'prestamo', 'rechazado', '2024-02-10', NULL),
(4, 5, 5, 3, 'intercambio', 'pendiente', '2024-03-01', NULL),
(5, NULL, 6, 4, 'prestamo', 'aceptado', '2024-03-10', '2024-03-25'),
(6, 7, 7, 5, 'intercambio', 'pendiente', '2024-03-15', NULL),
(7, NULL, 8, 6, 'prestamo', 'finalizado', '2024-01-10', '2024-01-18'),
(8, NULL, 9, 7, 'prestamo', 'pendiente', '2024-04-01', NULL),
(9, 10, 10, 8, 'intercambio', 'aceptado', '2024-04-12', '2024-04-28'),
(10, NULL, 1, 9, 'prestamo', 'rechazado', '2024-05-01', NULL);


-- ============================================================
-- 4. CONVERSACIONES (10 registros)
-- ============================================================
INSERT INTO conversaciones (id_usuario1, id_usuario2, id_intercambio)
VALUES
(1, 2, 1),
(3, 1, 2),
(4, 2, 3),
(5, 3, 4),
(6, 4, 5),
(7, 5, 6),
(8, 6, 7),
(9, 7, 8),
(10, 8, 9),
(2, 9, 10);


-- ============================================================
-- 5. MENSAJES (10 registros)
-- ============================================================
INSERT INTO mensajes (id_conversacion, id_remitente, contenido)
VALUES
(1, 1, 'Hola, ¿está disponible?'),
(1, 2, 'Sí, aún lo tengo.'),
(2, 3, '¿Cuándo podemos quedar?'),
(3, 4, '¿Aceptas intercambio?'),
(4, 5, 'Me interesa tu prenda.'),
(5, 6, '¿Podemos vernos mañana?'),
(6, 7, '¿Qué condición tiene?'),
(7, 8, 'Ya lo devolví.'),
(8, 9, 'Gracias por responder.'),
(9, 10, 'Podemos negociar.');


-- ============================================================
-- 6. VALORACIONES (10 registros)
-- ============================================================
INSERT INTO valoraciones (id_valorador, id_valorado, puntuacion)
VALUES
(1, 2, 5),
(2, 1, 4),
(3, 4, 5),
(4, 3, 3),
(5, 6, 4),
(6, 5, 5),
(7, 8, 4),
(8, 7, 5),
(9, 10, 3),
(10, 9, 4);
