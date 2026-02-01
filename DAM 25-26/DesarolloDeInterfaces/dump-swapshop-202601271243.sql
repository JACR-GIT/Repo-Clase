/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.7.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: swapshop
-- ------------------------------------------------------
-- Server version	12.0.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `conversaciones`
--

DROP TABLE IF EXISTS `conversaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `conversaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario1` int(11) NOT NULL,
  `id_usuario2` int(11) NOT NULL,
  `id_intercambio` int(11) NOT NULL,
  `creado_en` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `fk_conv_usuario1` (`id_usuario1`),
  KEY `fk_conv_usuario2` (`id_usuario2`),
  KEY `fk_conv_intercambio` (`id_intercambio`),
  CONSTRAINT `fk_conv_intercambio` FOREIGN KEY (`id_intercambio`) REFERENCES `intercambios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_conv_usuario1` FOREIGN KEY (`id_usuario1`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_conv_usuario2` FOREIGN KEY (`id_usuario2`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversaciones`
--

LOCK TABLES `conversaciones` WRITE;
/*!40000 ALTER TABLE `conversaciones` DISABLE KEYS */;
INSERT INTO `conversaciones` VALUES
(1,1,2,1,'2025-12-15 07:37:08'),
(2,3,1,2,'2025-12-15 07:37:08'),
(3,4,2,3,'2025-12-15 07:37:08'),
(4,5,3,4,'2025-12-15 07:37:08'),
(5,6,4,5,'2025-12-15 07:37:08'),
(6,7,5,6,'2025-12-15 07:37:08'),
(7,8,6,7,'2025-12-15 07:37:08'),
(8,9,7,8,'2025-12-15 07:37:08'),
(9,10,8,9,'2025-12-15 07:37:08'),
(10,2,9,10,'2025-12-15 07:37:08');
/*!40000 ALTER TABLE `conversaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intercambios`
--

DROP TABLE IF EXISTS `intercambios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `intercambios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_prenda` int(11) NOT NULL,
  `id_prenda2` int(11) DEFAULT NULL,
  `id_solicitante` int(11) NOT NULL,
  `id_dueno` int(11) NOT NULL,
  `tipo` enum('INTERCAMBIO','PRESTAMO') NOT NULL,
  `estado` enum('PENDIENTE','ACEPTADO','RECHAZADO','FINALIZADO') DEFAULT 'PENDIENTE',
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `creado_en` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `fk_intercambio_prenda` (`id_prenda`),
  KEY `fk_intercambio_prenda2` (`id_prenda2`),
  KEY `fk_intercambio_solicitante` (`id_solicitante`),
  KEY `fk_intercambio_dueno` (`id_dueno`),
  CONSTRAINT `fk_intercambio_dueno` FOREIGN KEY (`id_dueno`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_intercambio_prenda` FOREIGN KEY (`id_prenda`) REFERENCES `prendas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_intercambio_prenda2` FOREIGN KEY (`id_prenda2`) REFERENCES `prendas` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_intercambio_solicitante` FOREIGN KEY (`id_solicitante`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intercambios`
--

LOCK TABLES `intercambios` WRITE;
/*!40000 ALTER TABLE `intercambios` DISABLE KEYS */;
INSERT INTO `intercambios` VALUES
(1,1,NULL,2,1,'PRESTAMO','PENDIENTE','2024-01-01',NULL,'2025-12-15 07:37:08'),
(2,2,3,3,1,'INTERCAMBIO','ACEPTADO','2024-01-05','2024-01-20','2025-12-15 07:37:08'),
(3,3,NULL,4,2,'PRESTAMO','RECHAZADO','2024-02-10',NULL,'2025-12-15 07:37:08'),
(4,4,5,5,3,'INTERCAMBIO','ACEPTADO','2024-03-01',NULL,'2025-12-15 07:37:08'),
(5,5,NULL,6,4,'PRESTAMO','ACEPTADO','2024-03-10','2024-03-25','2025-12-15 07:37:08'),
(6,6,7,7,5,'INTERCAMBIO','PENDIENTE','2024-03-15',NULL,'2025-12-15 07:37:08'),
(7,7,NULL,8,6,'PRESTAMO','FINALIZADO','2024-01-10','2024-01-18','2025-12-15 07:37:08'),
(8,8,NULL,9,7,'PRESTAMO','PENDIENTE','2024-04-01',NULL,'2025-12-15 07:37:08'),
(9,9,10,10,8,'INTERCAMBIO','ACEPTADO','2024-04-12','2024-04-28','2025-12-15 07:37:08'),
(10,10,NULL,1,9,'PRESTAMO','RECHAZADO','2024-05-01',NULL,'2025-12-15 07:37:08'),
(11,2,4,3,4,'PRESTAMO','PENDIENTE','2026-10-20','2026-10-20','2025-12-15 07:52:24'),
(12,2,4,3,4,'PRESTAMO','PENDIENTE','2026-10-20','2026-10-20','2025-12-15 08:28:46');
/*!40000 ALTER TABLE `intercambios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_conversacion` int(11) NOT NULL,
  `id_remitente` int(11) NOT NULL,
  `contenido` text NOT NULL,
  `creado_en` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `fk_msg_conversacion` (`id_conversacion`),
  KEY `fk_msg_remitente` (`id_remitente`),
  CONSTRAINT `fk_msg_conversacion` FOREIGN KEY (`id_conversacion`) REFERENCES `conversaciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_msg_remitente` FOREIGN KEY (`id_remitente`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES
(1,1,1,'Hola, ¿está disponible?','2025-12-15 07:37:08'),
(2,1,2,'Sí, aún lo tengo.','2025-12-15 07:37:08'),
(3,2,3,'¿Cuándo podemos quedar?','2025-12-15 07:37:08'),
(4,3,4,'¿Aceptas intercambio?','2025-12-15 07:37:08'),
(5,4,5,'Me interesa tu prenda.','2025-12-15 07:37:08'),
(6,5,6,'¿Podemos vernos mañana?','2025-12-15 07:37:08'),
(7,6,7,'¿Qué condición tiene?','2025-12-15 07:37:08'),
(8,7,8,'Ya lo devolví.','2025-12-15 07:37:08'),
(9,8,9,'Gracias por responder.','2025-12-15 07:37:08'),
(10,9,10,'Podemos negociar.','2025-12-15 07:37:08');
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prendas`
--

DROP TABLE IF EXISTS `prendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `prendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_dueno` int(11) NOT NULL,
  `nombre_prenda` varchar(150) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `talla` varchar(20) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `estilo` enum('CASUAL','FORMAL','DEPORTIVO','STREETWEAR','ELEGANTE','VINTAGE','BOHEMIO','URBANO','ROCK','HIPSTER','MINIMALISTA','PREPPY','RETRO','GÓTICO','MILITAR','ETHNIC','CHIC','PUNK','SKATER','CLASSIC','BUSINESS','SMART_CASUAL','FASHIONISTA','AVANT_GARDE','ARTY','ROMANTICO','HIP_HOP','LOUNGE','ECOFRIENDLY','FESTIVAL','COUTURE','MODERNO','SOPHISTICATED','PLAYFUL','TROPICAL','BOYISH','GIRLY','ATHLEISURE') DEFAULT NULL,
  `condicion` enum('MALO','REGULAR','BUENA','MUY_BUENA','EXCELENTE') DEFAULT NULL,
  `disponible` tinyint(1) DEFAULT 1,
  `creado_en` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `fk_prendas_dueno` (`id_dueno`),
  CONSTRAINT `fk_prendas_dueno` FOREIGN KEY (`id_dueno`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prendas`
--

LOCK TABLES `prendas` WRITE;
/*!40000 ALTER TABLE `prendas` DISABLE KEYS */;
INSERT INTO `prendas` VALUES
(1,1,'Camiseta Roja','Camiseta básica roja','M','ROPA','CASUAL','BUENA',1,'2025-12-15 07:37:08'),
(2,1,'Pantalón Vaquero','Vaqueros azules','L','ROPA','CASUAL','EXCELENTE',1,'2025-12-15 07:37:08'),
(3,2,'Sudadera Negra','Sudadera con capucha','M','ROPA','CASUAL','BUENA',1,'2025-12-15 07:37:08'),
(4,3,'Chaqueta Cuero','Chaqueta estilo biker','L','ABRIGO','CASUAL','EXCELENTE',1,'2025-12-15 07:37:08'),
(5,4,'Vestido Azul','Vestido elegante azul','S','ROPA','CASUAL','BUENA',1,'2025-12-15 07:37:08'),
(6,5,'Zapatillas Nike','Zapatillas deportivas','42','CALZADO','CASUAL','REGULAR',1,'2025-12-15 07:37:08'),
(7,6,'Gorra Negra','Gorra deportiva ajustable','Única','ACCESORIO','CASUAL','BUENA',1,'2025-12-15 07:37:08'),
(8,7,'Bolso Marrón','Bolso piel sintética','Única','ACCESORIO','CASUAL','EXCELENTE',1,'2025-12-15 07:37:08'),
(9,8,'Falda Roja','Falda ajustada','S','ROPA','CASUAL','BUENA',1,'2025-12-15 07:37:08'),
(10,9,'Polo Blanco','Polo algodón blanco','M','ROPA','CASUAL','BUENA',1,'2025-12-15 07:37:08'),
(11,1,' normales','Vaqueros azules','XL','ROPA','CASUAL','EXCELENTE',1,'2025-12-15 07:50:40'),
(12,1,'Vaqueros','Vaqueros azules','XL','ROPA','CASUAL','BUENA',1,'2025-12-15 07:53:43'),
(13,1,'Vaqueros','Vaqueros azules','XL','ROPA','CASUAL','BUENA',1,'2025-12-15 08:34:48'),
(14,3,'Vaqueros','Vaqueros azules','XL','ROPA','CASUAL','BUENA',1,'2025-12-15 08:35:41'),
(15,1,'Vaqueros','Vaqueros azules','XL','ROPA','CASUAL','BUENA',1,'2025-12-15 08:57:43'),
(17,5,'Vaqueros','Vaqueros azules','XL','ROPA','CASUAL','BUENA',0,'2025-12-15 12:31:49');
/*!40000 ALTER TABLE `prendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) NOT NULL,
  `correo` varchar(150) NOT NULL,
  `contrasena` text NOT NULL,
  `fecha_nac` datetime(6) DEFAULT NULL,
  `creado_en` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES
(1,'juanito12','Juan','Pérez','Gómez','juan@gmail.com','123456','1990-05-12 00:00:00.000000','2025-12-15 07:37:08'),
(2,'maria23','María','López','Santos','maria@gmail.com','123456','1995-03-20 00:00:00.000000','2025-12-15 07:37:08'),
(3,'carlos88','Carlos','Martín','Ruiz','carlos@gmail.com','123456','1988-11-02 00:00:00.000000','2025-12-15 07:37:08'),
(4,'laura92','Laura','Sánchez','Díaz','laura@gmail.com','123456','1992-07-14 00:00:00.000000','2025-12-15 07:37:08'),
(5,'pepe01','José','Ramírez','Torres','pepe@gmail.com','123456','1998-01-30 00:00:00.000000','2025-12-15 07:37:08'),
(6,'ana77','Ana','Fernández','Rey','ana@gmail.com','123456','1977-10-10 00:00:00.000000','2025-12-15 07:37:08'),
(7,'luis55','Luis','Gil','Mora','luis@gmail.com','123456','1999-09-09 00:00:00.000000','2025-12-15 07:37:08'),
(8,'sofia44','Sofía','Vega','Castro','sofia@gmail.com','123456','2000-12-01 00:00:00.000000','2025-12-15 07:37:08'),
(9,'roberto10','Roberto','Navarro','Delgado','roberto@gmail.com','123456','1980-06-22 00:00:00.000000','2025-12-15 07:37:08'),
(10,'eva09','Eva','Romero','Flores','eva@gmail.com','123456','1994-04-17 00:00:00.000000','2025-12-15 07:37:08'),
(11,'Julian','Julian ','Navas','Medina','julian3@gmail.com','123456','2006-04-14 02:00:00.000000','2025-12-15 07:45:24'),
(12,'','Julian ','Navas','Medina','','123456','2027-04-14 02:00:00.000000','2025-12-15 07:54:33'),
(13,'oinv','Julian ','Navas','Medina','akjf@gmail.com','123456','2007-04-14 02:00:00.000000','2025-12-15 08:00:06'),
(14,'null','Julian ','Navas','Medina','akjf32432@gmail.com','123456','2007-04-14 02:00:00.000000','2025-12-15 12:28:48'),
(15,'Josew','Julian ','Navas','Medina','12@gmail.com','123456','2007-04-14 02:00:00.000000','2025-12-15 13:10:08');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoraciones`
--

DROP TABLE IF EXISTS `valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_valorador` int(11) NOT NULL,
  `id_valorado` int(11) NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `creado_en` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `fk_valorador` (`id_valorador`),
  KEY `fk_valorado` (`id_valorado`),
  CONSTRAINT `fk_valorado` FOREIGN KEY (`id_valorado`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_valorador` FOREIGN KEY (`id_valorador`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones`
--

LOCK TABLES `valoraciones` WRITE;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
INSERT INTO `valoraciones` VALUES
(1,1,2,5,'2025-12-15 07:37:08'),
(2,2,1,4,'2025-12-15 07:37:08'),
(3,3,4,5,'2025-12-15 07:37:08'),
(4,4,3,3,'2025-12-15 07:37:08'),
(5,5,6,4,'2025-12-15 07:37:08'),
(6,6,5,5,'2025-12-15 07:37:08'),
(7,7,8,4,'2025-12-15 07:37:08'),
(8,8,7,5,'2025-12-15 07:37:08'),
(9,9,10,3,'2025-12-15 07:37:08'),
(10,10,9,4,'2025-12-15 07:37:08'),
(11,11,2,5,'2025-12-15 07:45:48'),
(12,4,2,5,'2025-12-15 08:07:21'),
(13,5,2,5,'2025-12-15 12:30:31'),
(14,11,2,5,'2025-12-15 12:30:38');
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'swapshop'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2026-01-27 12:43:30
