/*

DROP TABLE alumnos_canciones;
DROP TABLE canciones;
DROP TABLE profesores_centros_asignaturas;
DROP TABLE profesores;
DROP TABLE alumnos_asignaturas;
DROP TABLE asignaturas;
DROP TABLE alumnos;
DROP TABLE centros;

*/
-- Ejecuta primero esta línea solo y luego el resto de script. No olvides hacer commit de los inserts.
SET DEFINE OFF; -- desactiva interpretación de variables de sustitución

-- Creación de las tablas
CREATE TABLE centros (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    localidad VARCHAR2(100) NOT NULL,
    tfno_contacto VARCHAR2(15) NOT NULL
);

CREATE TABLE alumnos (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL,
    apellidos VARCHAR2(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    id_centro NUMBER NOT NULL,
    FOREIGN KEY (id_centro) REFERENCES centros(id)
);

CREATE TABLE asignaturas (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL
);

CREATE TABLE alumnos_asignaturas (
    id_alumno NUMBER NOT NULL,
    id_asignatura NUMBER NOT NULL,
    nota NUMBER(4,2),
    PRIMARY KEY (id_alumno, id_asignatura),
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id),
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas(id)
);

CREATE TABLE profesores (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL,
    titulacion VARCHAR2(100) NOT NULL
);

CREATE TABLE profesores_centros_asignaturas (
    id_profesor NUMBER NOT NULL,
    id_centro NUMBER NOT NULL,
    id_asignatura NUMBER NOT NULL,
    PRIMARY KEY (id_profesor, id_centro, id_asignatura),
    FOREIGN KEY (id_profesor) REFERENCES profesores(id),
    FOREIGN KEY (id_centro) REFERENCES centros(id),
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas(id)
);

CREATE TABLE canciones (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titulo VARCHAR2(100) NOT NULL,
    artista VARCHAR2(100) NOT NULL
);

CREATE TABLE alumnos_canciones (
    id_alumno NUMBER NOT NULL,
    id_cancion NUMBER NOT NULL,
    reproducciones NUMBER NOT NULL,
    PRIMARY KEY (id_alumno, id_cancion),
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id),
    FOREIGN KEY (id_cancion) REFERENCES canciones(id)
);

-- Inserción de datos
-- Centros
INSERT INTO centros (nombre, localidad, tfno_contacto) VALUES ('IES Isaac Newton', 'Madrid', '912345678');
INSERT INTO centros (nombre, localidad, tfno_contacto) VALUES ('IES Viladomat', 'Barcelona', '932345678');
INSERT INTO centros (nombre, localidad, tfno_contacto) VALUES ('IES Pino Montano', 'Sevilla', '954345678');

-- Alumnos (10 alumnos)
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Carlos', 'Gómez López', DATE '2006-03-15', 1);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Lucía', 'Fernández Pérez', DATE '2005-08-21', 2);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Marina', 'Ruiz Sánchez', DATE '2006-01-10', 3);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Javier', 'Martínez García', DATE '2005-11-30', 1);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Sofía', 'Hernández Díaz', DATE '2006-05-22', 2);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Daniel', 'González Martín', DATE '2005-09-14', 3);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Elena', 'López Rodríguez', DATE '2006-02-18', 1);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Pablo', 'Díaz Sánchez', DATE '2005-07-09', 2);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Clara', 'Sánchez Gómez', DATE '2006-04-25', 3);
INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES ('Adrián', 'Pérez Ruiz', DATE '2005-12-05', 1);


-- Asignaturas (Incluyendo algunas sin alumnos)
INSERT INTO asignaturas (nombre) VALUES ('Matemáticas');
INSERT INTO asignaturas (nombre) VALUES ('Biología');
INSERT INTO asignaturas (nombre) VALUES ('Física');
INSERT INTO asignaturas (nombre) VALUES ('Filosofía');
INSERT INTO asignaturas (nombre) VALUES ('Música');
INSERT INTO asignaturas (nombre) VALUES ('Historia');

-- Relación alumnos - asignaturas con notas
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (1, 1, 8.5);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (1, 2, 7);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (1, 3, 4.5);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (2, 1, 7.3);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (2, 2, 6.3);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (2, 3, 10.0);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (3, 4, 10.0);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (3, 6, 10.0);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (4, 6, 8.0);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (4, 4, null);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (5, 6, 7.9);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (5, 4, null);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (6, 6, 9.9);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (6, 4, 8.1);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (7, 1, 5.5);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (7, 2, 6);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (7, 3, 6.5);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (8, 1, 7);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (8, 2, null);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (8, 3, 8.3);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (9, 1, null);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (9, 2, null);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (9, 3, 3.4);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (10, 1, 10);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (10, 2, 9.5);
INSERT INTO alumnos_asignaturas (id_alumno, id_asignatura, nota) VALUES (10, 3, 10);

-- Agregar más relaciones...

-- Profesores (6 profesores)
INSERT INTO profesores (nombre, titulacion) VALUES ('María López', 'Licenciada en Matemáticas');
INSERT INTO profesores (nombre, titulacion) VALUES ('Antonio García', 'Licenciado en Química');
INSERT INTO profesores (nombre, titulacion) VALUES ('Sofía Martínez', 'Doctora en Física');
INSERT INTO profesores (nombre, titulacion) VALUES ('Juan Pérez', 'Doctor en Historia');
INSERT INTO profesores (nombre, titulacion) VALUES ('Carmen Rodríguez', 'Graduada en Filología Hispánica');
INSERT INTO profesores (nombre, titulacion) VALUES ('David Fernández', 'Graduado en Filosoía');

INSERT INTO profesores (nombre, titulacion) VALUES ('Juan Albánchez', 'Doctor en Matemáticas');
INSERT INTO profesores (nombre, titulacion) VALUES ('Fernando Rodríguez', 'Docto en Química');
INSERT INTO profesores (nombre, titulacion) VALUES ('Berto Martínez', 'Graduado en Física');
INSERT INTO profesores (nombre, titulacion) VALUES ('Alicia Fuentes', 'Doctora en Historia');
INSERT INTO profesores (nombre, titulacion) VALUES ('Carmelo Rodríguez', 'Graduado en Filología Hispánica');
INSERT INTO profesores (nombre, titulacion) VALUES ('Sonia Ferrer', 'Licenciada en Filosoía');

INSERT INTO profesores (nombre, titulacion) VALUES ('Raquel Alcalde', 'Graduada en Matemáticas');
INSERT INTO profesores (nombre, titulacion) VALUES ('José Mena', 'Doctor en Química');
INSERT INTO profesores (nombre, titulacion) VALUES ('Alberto Jiménez', 'Doctor en Física');
INSERT INTO profesores (nombre, titulacion) VALUES ('Inés Velasco', 'Doctora en Historia');
INSERT INTO profesores (nombre, titulacion) VALUES ('Daniel Padilla', 'Graduado en Filología Hispánica');
INSERT INTO profesores (nombre, titulacion) VALUES ('Patricia López', 'Doctora en Filosoía');

-- Relación profesores - centros - asignaturas
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (1, 1, 1);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (2, 1, 2);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (3, 1, 3);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (4, 1, 6);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (6, 1, 4);

INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (7, 2, 1);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (8, 2, 2);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (9, 2, 3);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (10, 2, 6);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (12, 2, 4);

INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (13, 3, 1);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (14, 3, 2);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (15, 3, 3);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (16, 3, 6);
INSERT INTO profesores_centros_asignaturas (id_profesor, id_centro, id_asignatura) VALUES (18, 3, 4);

-- Canciones
insert into canciones(titulo, artista) values ('IA', 'Myke Towers');
insert into canciones(titulo, artista) values ('Q U E V A S H A C E R H O Y ?', 'Myke Towers feat. benny blanco');
insert into canciones(titulo, artista) values ('Nueva Era', 'Duki feat. Myke Towers');
insert into canciones(titulo, artista) values ('Si antes te hubiera conocido', 'Karol G');
insert into canciones(titulo, artista) values ('Se pone las Nike', 'Bad Gyal');
insert into canciones(titulo, artista) values ('Duro de verdad pt.2', 'Myke Towers feat. Bad Gyal');
insert into canciones(titulo, artista) values ('STAR', 'JC Reyes');
insert into canciones(titulo, artista) values ('Luna llena', 'Beny Jr');
insert into canciones(titulo, artista) values ('Rata de dos patas', 'Paquita la del Barrio');
insert into canciones(titulo, artista) values ('La vita e'' bella', 'Nicola Piovani');
insert into canciones(titulo, artista) values ('True', 'Spandau Ballet');
insert into canciones(titulo, artista) values ('Belong Together', 'Mark Ambor');
insert into canciones(titulo, artista) values ('Stand up and Be Counted', 'Aaron Kaplan');
insert into canciones(titulo, artista) values ('Me has invitado a bailar', 'Dani Fernández');
insert into canciones(titulo, artista) values ('Te Confieso', 'DePol');
insert into canciones(titulo, artista) values ('Die With A Smile', 'Lady Gaga');
insert into canciones(titulo, artista) values ('BBQ Guy', 'Rene Muenzer');
insert into canciones(titulo, artista) values ('Ballade', 'Crispin Merrell');
insert into canciones(titulo, artista) values ('Cupido', 'Beret');
insert into canciones(titulo, artista) values ('World Heritage (Full)', 'Fabrizio Pigliucci');
insert into canciones(titulo, artista) values ('Cosas Pendientes', 'Maluma');
insert into canciones(titulo, artista) values ('DEGENERE', 'Myke Towers & Juhn');
insert into canciones(titulo, artista) values ('Quiero Decirte', 'Ana Mena');
insert into canciones(titulo, artista) values ('Como el Perro y el Gato', 'Carlos Rodríguez, Dani Solis & Iván de las Heras');
insert into canciones(titulo, artista) values ('Trash Talkin', 'Jeremy Godfrey');
insert into canciones(titulo, artista) values ('Qué Pecao', 'Manuel Turizo');
insert into canciones(titulo, artista) values ('The Door', 'Teddy Swims');
insert into canciones(titulo, artista) values ('Born With a Broken Heart', 'Damiano David');
insert into canciones(titulo, artista) values ('Qué Pasaría...', 'Rauw Alejandro');
insert into canciones(titulo, artista) values ('Last Dance', 'Lincoln Grounds & Thomm Jutz');
insert into canciones(titulo, artista) values ('Good Mood Ukulele', 'David Ohana');
insert into canciones(titulo, artista) values ('High Above', 'Songs To Your Eyes');
insert into canciones(titulo, artista) values ('Don''t Stop', 'The Rolling Stones');
insert into canciones(titulo, artista) values ('El Partidazo (COPE)', 'Huecco');
insert into canciones(titulo, artista) values ('Mess It Up', 'Purple Disco Machine Remix');
insert into canciones(titulo, artista) values ('The Little Giant', 'Sebastian Arno Sprenger');
insert into canciones(titulo, artista) values ('Mi Refe', 'Beele');
insert into canciones(titulo, artista) values ('That''s So True', 'Gracie Abrams');
insert into canciones(titulo, artista) values ('Hopeful Road', 'Inspired Music');
insert into canciones(titulo, artista) values ('Summer Kicks', 'Will May');
insert into canciones(titulo, artista) values ('A Bar Song (Tipsy)', 'Shaboozey');
insert into canciones(titulo, artista) values ('Pueblo Salvaje', 'Manuel Carrasco');
insert into canciones(titulo, artista) values ('In Series', 'Richard Lacy, Sarah Lacy, Simeon Wood & Simon Bernard-Smith');
insert into canciones(titulo, artista) values ('NUEVAYoL', 'Bad Bunny');
insert into canciones(titulo, artista) values ('SEGUNDO INTENTO', 'Aitana Ocaña & Ana Guerra');
insert into canciones(titulo, artista) values ('Cero', 'Dani Martín');

-- Relación alumnos - canciones con reproducciones
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (1, 1, 35);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (1, 2, 20);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (1, 3, 15);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (1, 7, 17);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (1, 21, 25);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (1, 30, 5);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (1, 40, 18);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (1, 29, 40);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (2, 4, 10);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (2, 10, 15);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (2, 24, 20);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (2, 21, 40);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (2, 22, 50);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (2, 16, 38);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (2, 39, 4);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (3, 7, 9);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (3, 17, 28);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (3, 27, 55);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (3, 37, 42);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (3, 12, 23);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (3, 44, 12);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (4, 6, 19);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (4, 8, 17);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (4, 9, 11);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (4, 11, 12);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (4, 14, 26);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (4, 29, 20);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (4, 32, 30);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (4, 36, 18);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (5, 16, 19);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (5, 28, 17);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (5, 19, 11);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (5, 21, 15);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (5, 34, 28);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (5, 9, 21);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (5, 2, 31);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (5, 43, 17);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (6, 36, 19);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (6, 38, 17);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (6, 39, 11);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (6, 11, 15);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (6, 24, 28);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (6, 29, 21);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (6, 7, 31);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (6, 40, 17);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (7, 16, 49);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (7, 8, 17);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (7, 9, 21);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (7, 27, 15);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (7, 37, 28);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (7, 13, 21);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (7, 3, 33);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (7, 40, 27);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (8, 26, 2);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (8, 18, 3);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (8, 39, 1);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (9, 16, 102);

INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (10, 1, 49);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (10, 2, 17);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (10, 43, 31);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (10, 39, 25);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (10, 37, 42);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (10, 25, 11);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (10, 38, 23);
INSERT INTO alumnos_canciones (id_alumno, id_cancion, reproducciones) VALUES (10, 19, 7);


