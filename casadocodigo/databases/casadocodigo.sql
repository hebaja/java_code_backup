-- MariaDB dump 10.17  Distrib 10.4.7-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: casadocodigo
-- ------------------------------------------------------
-- Server version	10.4.7-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Produto`
--

DROP TABLE IF EXISTS `Produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `paginas` int(11) NOT NULL,
  `titulo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dataLancamento` datetime DEFAULT NULL,
  `sumarioPath` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto`
--

LOCK TABLES `Produto` WRITE;
/*!40000 ALTER TABLE `Produto` DISABLE KEYS */;
INSERT INTO `Produto` VALUES (4,'Aprenda a fazer testes unitários no mundo real.',220,'TDD Total Já','2019-07-15 00:00:00',NULL),(5,'Java para iniciantes.',450,'Java Total','2019-07-28 00:00:00',NULL),(7,'Criação de apps para a plataforma Android',480,'Android Básico','2019-04-21 00:00:00',NULL),(9,'Aprenda css de forma dinâmica.',150,'CSS rápido','2019-04-08 00:00:00',NULL),(10,'Curso básico HTML.',320,'HTML em casa','2019-03-15 00:00:00',NULL),(11,'Inicie no mundo PHP',450,'Livro PHP iniciantes','2019-03-19 00:00:00',NULL),(12,'Aprenda a lógica inicial.',120,'Lógica de programação','2019-05-11 00:00:00',NULL),(13,'Aprenda a beber água da maneira correta.',100,'Cuso de Bebeção de Água','2019-06-05 00:00:00',NULL),(14,'Dê voleio na picanha.',120,'Curso de Churrasco','2019-05-11 00:00:00',NULL),(15,'Seja o mestre da manobra.',57,'Curso de Cambalhota','2019-06-15 00:00:00','/home/focus/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/casadocodigo/arquivos-sumario/cambalhota.jpg'),(16,'Seja o melhor na caminhada.',50,'Aprenda a andar corretamente','2019-05-11 00:00:00','/arquivos-sumario/caminhada-.jpg'),(17,'Melhor técnica.',25,'Aprenda a falar baixo','2019-02-15 00:00:00','/arquivos-sumario/Arch Gradient Dark 1440P.jpg'),(37,'seja o melhor',12,'Como enxugar gelo','2019-07-15 00:00:00','/arquivos-sumario/');
/*!40000 ALTER TABLE `Produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Produto_precos`
--

DROP TABLE IF EXISTS `Produto_precos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Produto_precos` (
  `Produto_id` int(11) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  KEY `FK_hl4xdmygc7v2x607r4rbs6x3a` (`Produto_id`),
  CONSTRAINT `FK_hl4xdmygc7v2x607r4rbs6x3a` FOREIGN KEY (`Produto_id`) REFERENCES `Produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto_precos`
--

LOCK TABLES `Produto_precos` WRITE;
/*!40000 ALTER TABLE `Produto_precos` DISABLE KEYS */;
INSERT INTO `Produto_precos` VALUES (4,0,39.00),(4,1,49.00),(4,2,59.00),(5,0,49.00),(5,1,59.00),(5,2,69.00),(7,0,59.00),(7,1,69.00),(7,2,79.00),(9,0,19.00),(9,1,29.00),(9,2,39.00),(10,0,19.00),(10,1,29.00),(10,2,39.00),(11,0,29.00),(11,1,39.00),(11,2,49.00),(12,0,19.00),(12,1,29.00),(12,2,39.00),(13,0,19.00),(13,1,29.00),(13,2,39.00),(14,0,19.00),(14,1,29.00),(14,2,39.00),(15,0,15.00),(15,1,25.00),(15,2,30.00),(16,0,10.00),(16,1,20.00),(16,2,25.00),(17,0,10.00),(17,1,15.00),(17,2,20.00),(37,0,15.00),(37,1,16.00),(37,2,17.00);
/*!40000 ALTER TABLE `Produto_precos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES ('ROLE_ADMIN'),('ROLE_COMERCIAL'),('ROLE_USER');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `senha` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `senhaRepetida` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('admin@casadocodigo.com.br','Administrador','$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq',NULL),('armando@gmail.com','armando','123456','123456'),('asdrubal@gmail.com','asdrubal','123456','123456'),('candoca@gmail.com','candoca','789456','789456'),('geraldo@gmail.com','geraldo','123456','123456'),('jujuba@gmail.com','jujuba','123456','123456'),('jupira@gmail.com','jupira','$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq','$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq'),('zumira@gmail.com','zumira','123456','123456');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario_Role`
--

DROP TABLE IF EXISTS `Usuario_Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario_Role` (
  `Usuario_email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  KEY `FK_4o3ac7d9n1iyu0ufrxbq8rx23` (`roles_name`),
  KEY `FK_fpipx83bjblmwmw25qotdyd3` (`Usuario_email`),
  CONSTRAINT `FK_4o3ac7d9n1iyu0ufrxbq8rx23` FOREIGN KEY (`roles_name`) REFERENCES `Role` (`name`),
  CONSTRAINT `FK_fpipx83bjblmwmw25qotdyd3` FOREIGN KEY (`Usuario_email`) REFERENCES `Usuario` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario_Role`
--

LOCK TABLES `Usuario_Role` WRITE;
/*!40000 ALTER TABLE `Usuario_Role` DISABLE KEYS */;
INSERT INTO `Usuario_Role` VALUES ('candoca@gmail.com','ROLE_COMERCIAL'),('candoca@gmail.com','ROLE_USER'),('admin@casadocodigo.com.br','ROLE_ADMIN'),('admin@casadocodigo.com.br','ROLE_COMERCIAL'),('admin@casadocodigo.com.br','ROLE_USER'),('armando@gmail.com','ROLE_ADMIN'),('armando@gmail.com','ROLE_COMERCIAL'),('armando@gmail.com','ROLE_USER'),('jupira@gmail.com','ROLE_USER'),('geraldo@gmail.com','ROLE_USER'),('jujuba@gmail.com','ROLE_COMERCIAL'),('jujuba@gmail.com','ROLE_USER'),('asdrubal@gmail.com','ROLE_COMERCIAL'),('asdrubal@gmail.com','ROLE_USER'),('zumira@gmail.com','ROLE_ADMIN');
/*!40000 ALTER TABLE `Usuario_Role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-02 15:43:50
