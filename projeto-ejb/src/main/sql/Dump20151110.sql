-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: infbloco
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id_aluno` int(11) NOT NULL AUTO_INCREMENT,
  `nm_aluno` varchar(150) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_aluno`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'FRANCISCO MOREIRA DA SILVA','tche_aurelio@hotmail.com','M'),(2,'MARIA DA CONCEICAO SOARES DOS SANTOS','tche_aurelio@hotmail.com','F'),(3,'GERALDO LEITE BRANDAO','tche_aurelio@hotmail.com','M'),(4,'FRANCISCO MARTINS BORGES','tcheaurelio@gmail.com','M'),(5,'CLAUDIO FERREIRA CAVALCANTE','mrmello@gmail.com','M'),(6,'JADER CALACINA DANTAS','mrmello@gmail.com','M'),(7,'JANETE OLIVEIRA DE MOURA FRANCA','mrmello@gmail.com','F'),(8,'RICARDO SOUZA DA SILVA','lickerls@hotmail.com','M'),(9,'MARIA BATISTA MONTEIRO','lickerls@hotmail.com','F'),(10,'ROSIMEIRE FERREIRA CALIXTO','tcheaurelio@gmail.com','F'),(11,'FRANCISCO DE OLIVEIRA TRINDADE','tche_aurelio@hotmail.com','M'),(12,'JOSIMARIA BANDEIRA DE FRANCA','lickerls@hotmail.com','F'),(13,'JOCICLEUDO DE SOUZA FROTA','tche_aurelio@hotmail.com','M'),(14,'MARIA ORALICE FREIRE','mrmello@gmail.com','F'),(15,'CAZIMIRO CAVALCANTE DE OLIVEIRA','tcheaurelio@gmail.com','M'),(16,'NERILSON ANDRADE DE OLIVEIRA','lickerls@hotmail.com','M'),(17,'JOAO ESTEPHAN AMORIN BARBARY','lickerls@hotmail.com','M'),(18,'RAIMUNDA NILDOMAR TELES BEZERRA','lickerls@hotmail.com','F'),(19,'ALDERLEI DA SILVA MACIEL','tcheaurelio@gmail.com','M'),(20,'LAIDES MAGALHAES DAMASCENO','lickerls@hotmail.com','F'),(21,'NORANEIDE ALVES DA SILVA','lickerls@hotmail.com','F'),(22,'CARLOS HENRIQUE GUIMARAES SARAH','tche_aurelio@hotmail.com','M'),(23,'ANA MARIA SANTOS RODRIGUES','mrmello@gmail.com','F'),(24,'CLAUDENICE DA SILVA NEPOMUCENO DO NASCIMENTO','tche_aurelio@hotmail.com','F'),(25,'JOAO SOARES DE SOUZA','tcheaurelio@gmail.com','M'),(26,'MARIA DAS DORES DE SOUZA','lickerls@hotmail.com','F'),(27,'EURICO NUNES CARDOZO','mrmello@gmail.com','M'),(28,'IRISMAR OLIVEIRA DA SILVA','mrmello@gmail.com','M'),(29,'RAIMUNDO GUSTAVO ALMEIDA DE CARVALHO','lickerls@hotmail.com','M'),(30,'SEBASTIAO DE ASSIS LIMA','lickerls@hotmail.com','M'),(31,'MARIA JOSE LIMA MENDES','mrmello@gmail.com','F'),(32,'NEIDE BATISTA DO AMARAL','tcheaurelio@gmail.com','F'),(33,'NEIDE DE LARA','lickerls@hotmail.com','F'),(34,'FRANCISCA ALRICELIA CARDOSO DA SILVA','tche_aurelio@hotmail.com','F'),(35,'JOSE SOUZA DA SILVA','tche_aurelio@hotmail.com','M'),(36,'REGIANE MARIA DA SILVA ROLA','tche_aurelio@hotmail.com','F'),(37,'ELZA RODRIGUES DA SILVA','mrmello@gmail.com','F'),(38,'JOSE RAIMUNDO ALVES DE SOUSA','mrmello@gmail.com','M'),(39,'MARIA LUCIA DOS SANTOS LEITE','tche_aurelio@hotmail.com','F'),(40,'JOSE ALVES BEZERRA','tche_aurelio@hotmail.com','F'),(41,'JOSE SARAIVA DO VALE JUNIOR','mrmello@gmail.com','M'),(42,'PAULO HERONCIO DE OLIVEIRA','lickerls@hotmail.com','M'),(43,'ROSANIA GUEDES DA ROCHA','tche_aurelio@hotmail.com','F'),(44,'ANTONIO MARIANO OLIVEIRA NUNES','mrmello@gmail.com','M'),(45,'FRANCISCO CORREIA DE ARAUJO','lickerls@hotmail.com','M'),(46,'DAGMAR VIEIRA DA SILVA','tche_aurelio@hotmail.com','F'),(47,'PAULO BARBOSA DE SOUZA','lickerls@hotmail.com','M'),(48,'MARIA DAS DORES DANTAS DA SILVA','tche_aurelio@hotmail.com','F'),(49,'MARIA DAS DORES DANTAS DA SILVA','mrmello@gmail.com','F'),(50,'FRANCISCO BATISTA DE SOUZA','lickerls@hotmail.com','M'),(51,'FRANCISCA FERREIRA DA SILVA MELO','mrmello@gmail.com','F'),(52,'ROGEVANIO SILVA DO NASCIMENTO','mrmello@gmail.com','M'),(53,'GERONILDE DA SILVA RODRIGUES','tche_aurelio@hotmail.com','F'),(54,'COSMO RODRIGUES DA COSTA','mrmello@gmail.com','M'),(55,'FRANCISCO TARCISO PACHECO','mrmello@gmail.com','M'),(56,'LINDOMAR ALMEIDA DE SOUZA','lickerls@hotmail.com','M'),(57,'TERESINHA DANTAS DE ARAUJO','mrmello@gmail.com','F'),(58,'IVONILDES DA COSTA CARDOSO','tche_aurelio@hotmail.com','F'),(59,'TORQUATA CRUZ DE SOUSA','lickerls@hotmail.com','F'),(60,'JONAS CLAUDIO DE ASSIS','tche_aurelio@hotmail.com','M'),(61,'JOAO PAULINO DE CAMPOS NETO','mrmello@gmail.com','M'),(62,'MARIA RAILENE SANTIAGO PINHEIRO','lickerls@hotmail.com','F'),(63,'EDSON MEDEIRO DA SILVA','tche_aurelio@hotmail.com','M'),(64,'ALDEMIRA FERNANDES DE OLIVEIRA','tche_aurelio@hotmail.com','F'),(65,'ELIZENI DA COSTA LUZ','lickerls@hotmail.com','F'),(66,'LEILA GRARCIENE CORREA DE SOUZA','mrmello@gmail.com','F'),(67,'VALDINEA MATOS DOS SANTOS','mrmello@gmail.com','F'),(68,'ORTENCIA GALBIATI DE OLIVEIRA','lickerls@hotmail.com','F'),(69,'ELCINEIDE AGUIAR DOS SANTOS','mrmello@gmail.com','F'),(70,'ELCINEIDE AGUIAR DOS SANTOS','tche_aurelio@hotmail.com','F'),(71,'RENATO RIBEIRO DE MESQUITA','mrmello@gmail.com','M'),(72,'MARIA ROSSINEIDE BARROS DE MOURA','tche_aurelio@hotmail.com','F'),(73,'GERUZA MACIEL DA SILVA','lickerls@hotmail.com','F'),(74,'RAIMUNDO RODRIGUES DE FREITAS','mrmello@gmail.com','M'),(75,'ALIPIO DA SILVEIRA TORRES','lickerls@hotmail.com','M'),(76,'FRANCISCO ROSEMIRO BARRETO BARROSO','tche_aurelio@hotmail.com','M'),(77,'FRANCISCO FERLENO DE SOUZA','mrmello@gmail.com','M'),(78,'AMILTON VIEIRA','mrmello@gmail.com','M'),(79,'MARIA ALICE GOUVEIA DE OLIVEIRA','lickerls@hotmail.com','F'),(80,'DOMINGOS SALVIO LOPES CABANELAS','tche_aurelio@hotmail.com','M'),(81,'ANTONIO BATISTA VIEIRA','lickerls@hotmail.com','M'),(82,'ROSALI EVARISTO DA SILVA','mrmello@gmail.com','F'),(83,'ECY OLIVEIRA DE CARVALHO','mrmello@gmail.com','F'),(84,'FRANCISCO ALVES DA SILVA','lickerls@hotmail.com','M'),(85,'DANIELA ROCHA DOS SANTOS','lickerls@hotmail.com','F'),(86,'MANOEL DE JESUS BENICIO DA SILVA','tche_aurelio@hotmail.com','M'),(87,'JOAO PEREIRA DOS SANTOS','lickerls@hotmail.com','M'),(88,'FRANCISCA DE OLIVEIRA SILVA','tche_aurelio@hotmail.com','F'),(89,'OSMARINO ANDRADE DO NASCIMENTO','lickerls@hotmail.com','M'),(90,'ROSANGELA LOPES DA SILVA','mrmello@gmail.com','F');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloco`
--

DROP TABLE IF EXISTS `bloco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bloco` (
  `id_bloco` int(11) NOT NULL AUTO_INCREMENT,
  `nm_bloco` varchar(100) NOT NULL,
  `id_curso` int(11) NOT NULL,
  PRIMARY KEY (`id_bloco`),
  KEY `id_curso` (`id_curso`),
  CONSTRAINT `bloco_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloco`
--

LOCK TABLES `bloco` WRITE;
/*!40000 ALTER TABLE `bloco` DISABLE KEYS */;
INSERT INTO `bloco` VALUES (1,'Engenharia de Software',1),(2,'Programação Orientada a Objetos',1),(3,'Desenvolvimento Web',1),(4,'TCC',1);
/*!40000 ALTER TABLE `bloco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `nm_curso` varchar(100) NOT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'MIT em Engenharia de Software com Java');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo` (
  `id_modulo` int(11) NOT NULL AUTO_INCREMENT,
  `nm_modulo` varchar(100) NOT NULL,
  `id_bloco` int(11) NOT NULL,
  PRIMARY KEY (`id_modulo`),
  KEY `id_bloco` (`id_bloco`),
  CONSTRAINT `modulo_ibfk_1` FOREIGN KEY (`id_bloco`) REFERENCES `bloco` (`id_bloco`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES (1,'Projeto de Bloco - Engenharia de Software',1),(2,'Introdução à Engenharia de Software',1),(3,'Processos de Desenvolvimento de Software',1),(4,'Métricas de Desenvolvimento de Software',1),(5,'Análise e Projeto de Sistemas Orientados a Objetos',2),(6,'Projeto de Bloco - 2° bloco',2),(7,'Programação Orientadas a Objetos com Java',2),(8,'Acesso a dados, Multithreading e Interface gráfica em Java',2),(9,'Projeto de Bloco (Web e Componentes com JAVA)',3),(10,'Aplicação Web',3),(11,'Aplicações na Camada de Negócios',3),(12,'Tópicos Avançados',3);
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `id_professor` int(11) NOT NULL AUTO_INCREMENT,
  `nm_professor` varchar(150) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_professor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'Frederico Novaes','frederico.novaes@infnet.edu.br','M'),(2,'Tomás de Aquino Tinoco Botelho','aquino.botelho@infnet.edu.br','M'),(3,'Rogério Magela','','M'),(4,'Bruno Freitas Braga','','M'),(5,'Conrad Marques Peres','','M'),(6,'André Felix da Silva','','M'),(7,'Flavio Longue Guimarães','','M'),(8,'Manoel Pedro Sá','','M'),(9,'Thiago Medeiros','thiago.medeiros@prof.infnet.edu.br','M');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `id_turma` int(11) NOT NULL AUTO_INCREMENT,
  `nr_turma` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `id_modulo` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `dt_inicio` datetime DEFAULT NULL,
  `dt_fim` datetime DEFAULT NULL,
  PRIMARY KEY (`id_turma`),
  KEY `id_modulo` (`id_modulo`),
  KEY `id_aluno` (`id_aluno`),
  KEY `id_professor` (`id_professor`),
  CONSTRAINT `turma_ibfk_1` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`),
  CONSTRAINT `turma_ibfk_2` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`),
  CONSTRAINT `turma_ibfk_3` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,1,'Turma 1',2,1,2,NULL,NULL),(2,1,'Turma 1',2,2,2,NULL,NULL),(3,1,'Turma 1',2,3,2,NULL,NULL),(4,1,'Turma 1',2,4,2,NULL,NULL),(5,1,'Turma 1',2,5,2,NULL,NULL),(6,1,'Turma 1',2,6,2,NULL,NULL),(7,1,'Turma 1',2,7,2,NULL,NULL),(8,1,'Turma 1',2,8,2,NULL,NULL),(9,1,'Turma 1',2,9,2,NULL,NULL),(10,1,'Turma 1',2,10,2,NULL,NULL),(11,1,'Turma 1',2,11,2,NULL,NULL),(12,1,'Turma 1',2,12,2,NULL,NULL),(13,1,'Turma 1',2,13,2,NULL,NULL),(14,1,'Turma 1',2,14,2,NULL,NULL),(15,1,'Turma 1',2,15,2,NULL,NULL),(16,1,'Turma 1',2,16,2,NULL,NULL),(17,1,'Turma 1',2,17,2,NULL,NULL),(18,1,'Turma 1',2,18,2,NULL,NULL),(19,1,'Turma 1',2,19,2,NULL,NULL),(20,1,'Turma 1',2,20,2,NULL,NULL),(21,1,'Turma 1',2,21,2,NULL,NULL),(22,1,'Turma 1',2,22,2,NULL,NULL),(23,1,'Turma 1',2,23,2,NULL,NULL),(24,1,'Turma 1',2,24,2,NULL,NULL),(25,1,'Turma 1',2,25,2,NULL,NULL),(26,1,'Turma 1',2,26,2,NULL,NULL),(27,1,'Turma 1',2,27,2,NULL,NULL),(28,1,'Turma 1',2,28,2,NULL,NULL),(29,1,'Turma 1',2,29,2,NULL,NULL),(30,1,'Turma 1',2,30,2,NULL,NULL),(31,2,'Turma 2',8,31,6,NULL,NULL),(32,2,'Turma 2',8,32,6,NULL,NULL),(33,2,'Turma 2',8,33,6,NULL,NULL),(34,2,'Turma 2',8,34,6,NULL,NULL),(35,2,'Turma 2',8,35,6,NULL,NULL),(36,2,'Turma 2',8,36,6,NULL,NULL),(37,2,'Turma 2',8,37,6,NULL,NULL),(38,2,'Turma 2',8,38,6,NULL,NULL),(39,2,'Turma 2',8,39,6,NULL,NULL),(40,2,'Turma 2',8,40,6,NULL,NULL),(41,2,'Turma 2',8,41,6,NULL,NULL),(42,2,'Turma 2',8,42,6,NULL,NULL),(43,2,'Turma 2',8,43,6,NULL,NULL),(44,2,'Turma 2',8,44,6,NULL,NULL),(45,2,'Turma 2',8,45,6,NULL,NULL),(46,2,'Turma 2',8,46,6,NULL,NULL),(47,2,'Turma 2',8,47,6,NULL,NULL),(48,2,'Turma 2',8,48,6,NULL,NULL),(49,2,'Turma 2',8,49,6,NULL,NULL),(50,2,'Turma 2',8,50,6,NULL,NULL),(51,2,'Turma 2',8,51,6,NULL,NULL),(52,2,'Turma 2',8,52,6,NULL,NULL),(53,2,'Turma 2',8,53,6,NULL,NULL),(54,2,'Turma 2',8,54,6,NULL,NULL),(55,2,'Turma 2',8,55,6,NULL,NULL),(56,2,'Turma 2',8,56,6,NULL,NULL),(57,2,'Turma 2',8,57,6,NULL,NULL),(58,2,'Turma 2',8,58,6,NULL,NULL),(59,2,'Turma 2',8,59,6,NULL,NULL),(60,2,'Turma 2',8,60,6,NULL,NULL),(61,3,'Turma 3',11,61,8,NULL,NULL),(62,3,'Turma 3',11,62,8,NULL,NULL),(63,3,'Turma 3',11,63,8,NULL,NULL),(64,3,'Turma 3',11,64,8,NULL,NULL),(65,3,'Turma 3',11,65,8,NULL,NULL),(66,3,'Turma 3',11,66,8,NULL,NULL),(67,3,'Turma 3',11,67,8,NULL,NULL),(68,3,'Turma 3',11,68,8,NULL,NULL),(69,3,'Turma 3',11,69,8,NULL,NULL),(70,3,'Turma 3',11,70,8,NULL,NULL),(71,3,'Turma 3',11,71,8,NULL,NULL),(72,3,'Turma 3',11,72,8,NULL,NULL),(73,3,'Turma 3',11,73,8,NULL,NULL),(74,3,'Turma 3',11,74,8,NULL,NULL),(75,3,'Turma 3',11,75,8,NULL,NULL),(76,3,'Turma 3',11,76,8,NULL,NULL),(77,3,'Turma 3',11,77,8,NULL,NULL),(78,3,'Turma 3',11,78,8,NULL,NULL),(79,3,'Turma 3',11,79,8,NULL,NULL),(80,3,'Turma 3',11,80,8,NULL,NULL),(81,3,'Turma 3',11,81,8,NULL,NULL),(82,3,'Turma 3',11,82,8,NULL,NULL),(83,3,'Turma 3',11,83,8,NULL,NULL),(84,3,'Turma 3',11,84,8,NULL,NULL),(85,3,'Turma 3',11,85,8,NULL,NULL),(86,3,'Turma 3',11,86,8,NULL,NULL),(87,3,'Turma 3',11,87,8,NULL,NULL),(88,3,'Turma 3',11,88,8,NULL,NULL),(89,3,'Turma 3',11,89,8,NULL,NULL),(90,3,'Turma 3',11,90,8,NULL,NULL);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-10  0:47:16
