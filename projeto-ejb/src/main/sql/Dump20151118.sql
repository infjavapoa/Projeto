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
  `nr_matricula` int(11) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`id_aluno`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'FRANCISCO MOREIRA DA SILVA','tche_aurelio@hotmail.com','M',10001,'29727693172'),(2,'MARIA DA CONCEICAO SOARES DOS SANTOS','tche_aurelio@hotmail.com','F',10000,'18530249100'),(3,'GERALDO LEITE BRANDAO','tche_aurelio@hotmail.com','M',10002,'09797904172'),(4,'FRANCISCO MARTINS BORGES','tcheaurelio@gmail.com','M',10003,'12084867134'),(5,'CLAUDIO FERREIRA CAVALCANTE','mrmello@gmail.com','M',10004,'21008540110'),(6,'JADER CALACINA DANTAS','mrmello@gmail.com','M',10005,'11977027172'),(7,'JANETE OLIVEIRA DE MOURA FRANCA','mrmello@gmail.com','F',10006,'28106434100'),(8,'RICARDO SOUZA DA SILVA','lickerls@hotmail.com','M',10007,'92635881120'),(9,'MARIA BATISTA MONTEIRO','lickerls@hotmail.com','F',10008,'18872930782'),(10,'ROSIMEIRE FERREIRA CALIXTO','tcheaurelio@gmail.com','F',10009,'44456590106'),(11,'FRANCISCO DE OLIVEIRA TRINDADE','tche_aurelio@hotmail.com','M',10010,'33909245153'),(12,'JOSIMARIA BANDEIRA DE FRANCA','lickerls@hotmail.com','F',10011,'64760367187'),(13,'JOCICLEUDO DE SOUZA FROTA','tche_aurelio@hotmail.com','M',10012,'87555948168'),(14,'MARIA ORALICE FREIRE','mrmello@gmail.com','F',10013,'72056568187'),(15,'CAZIMIRO CAVALCANTE DE OLIVEIRA','tcheaurelio@gmail.com','M',10014,'47143134104'),(16,'NERILSON ANDRADE DE OLIVEIRA','lickerls@hotmail.com','M',10015,'49182218153'),(17,'JOAO ESTEPHAN AMORIN BARBARY','lickerls@hotmail.com','M',10016,'27113213120'),(18,'RAIMUNDA NILDOMAR TELES BEZERRA','lickerls@hotmail.com','F',10017,'47180021172'),(19,'ALDERLEI DA SILVA MACIEL','tcheaurelio@gmail.com','M',10018,'08452865104'),(20,'LAIDES MAGALHAES DAMASCENO','lickerls@hotmail.com','F',10019,'33805601620'),(21,'NORANEIDE ALVES DA SILVA','lickerls@hotmail.com','F',10020,'64569756891'),(22,'CARLOS HENRIQUE GUIMARAES SARAH','tche_aurelio@hotmail.com','M',10021,'18642608153'),(23,'ANA MARIA SANTOS RODRIGUES','mrmello@gmail.com','F',10022,'38092123187'),(24,'CLAUDENICE DA SILVA NEPOMUCENO DO NASCIMENTO','tche_aurelio@hotmail.com','F',10023,'28100026149'),(25,'JOAO SOARES DE SOUZA','tcheaurelio@gmail.com','M',10024,'17966051153'),(26,'MARIA DAS DORES DE SOUZA','lickerls@hotmail.com','F',10025,'14621320253'),(27,'EURICO NUNES CARDOZO','mrmello@gmail.com','M',10026,'09870520120'),(28,'IRISMAR OLIVEIRA DA SILVA','mrmello@gmail.com','M',10027,'64641520178'),(29,'RAIMUNDO GUSTAVO ALMEIDA DE CARVALHO','lickerls@hotmail.com','M',10028,'29709970100'),(30,'SEBASTIAO DE ASSIS LIMA','lickerls@hotmail.com','M',10029,'34265279104'),(31,'MARIA JOSE LIMA MENDES','mrmello@gmail.com','F',10030,'76951863172'),(32,'NEIDE BATISTA DO AMARAL','tcheaurelio@gmail.com','F',10031,'11523107120'),(33,'NEIDE DE LARA','lickerls@hotmail.com','F',10032,'12782661191'),(34,'FRANCISCA ALRICELIA CARDOSO DA SILVA','tche_aurelio@hotmail.com','F',10033,'04156528391'),(35,'JOSE SOUZA DA SILVA','tche_aurelio@hotmail.com','M',10034,'25884263104'),(36,'REGIANE MARIA DA SILVA ROLA','tche_aurelio@hotmail.com','F',10035,'41685199100'),(37,'ELZA RODRIGUES DA SILVA','mrmello@gmail.com','F',10036,'21465851100'),(38,'JOSE RAIMUNDO ALVES DE SOUSA','mrmello@gmail.com','M',10037,'39347281115'),(39,'MARIA LUCIA DOS SANTOS LEITE','tche_aurelio@hotmail.com','F',10038,'10259686115'),(40,'JOSE ALVES BEZERRA','tche_aurelio@hotmail.com','F',10039,'66662079120'),(41,'JOSE SARAIVA DO VALE JUNIOR','mrmello@gmail.com','M',10040,'03366979100'),(42,'PAULO HERONCIO DE OLIVEIRA','lickerls@hotmail.com','M',10041,'41749464187'),(43,'ROSANIA GUEDES DA ROCHA','tche_aurelio@hotmail.com','F',10042,'20940041391'),(44,'ANTONIO MARIANO OLIVEIRA NUNES','mrmello@gmail.com','M',10043,'77070283172'),(45,'FRANCISCO CORREIA DE ARAUJO','lickerls@hotmail.com','M',10044,'33957983134'),(46,'DAGMAR VIEIRA DA SILVA','tche_aurelio@hotmail.com','F',10045,'61996467115'),(47,'PAULO BARBOSA DE SOUZA','lickerls@hotmail.com','M',10046,'76568989134'),(48,'MARIA DAS DORES DANTAS DA SILVA','tche_aurelio@hotmail.com','F',10047,'27550397104'),(49,'MARIA DAS DORES DANTAS DA SILVA','mrmello@gmail.com','F',10048,'52434540104'),(50,'FRANCISCO BATISTA DE SOUZA','lickerls@hotmail.com','M',10049,'52416658115'),(51,'FRANCISCA FERREIRA DA SILVA MELO','mrmello@gmail.com','F',10050,'37592998149'),(52,'ROGEVANIO SILVA DO NASCIMENTO','mrmello@gmail.com','M',10051,'61038466172'),(53,'GERONILDE DA SILVA RODRIGUES','tche_aurelio@hotmail.com','F',10052,'35142820134'),(54,'COSMO RODRIGUES DA COSTA','mrmello@gmail.com','M',10053,'25865340182'),(55,'FRANCISCO TARCISO PACHECO','mrmello@gmail.com','M',10054,'31357458134'),(56,'LINDOMAR ALMEIDA DE SOUZA','lickerls@hotmail.com','M',10055,'56348916120'),(57,'TERESINHA DANTAS DE ARAUJO','mrmello@gmail.com','F',10056,'69826838187'),(58,'IVONILDES DA COSTA CARDOSO','tche_aurelio@hotmail.com','F',10057,'29641659120'),(59,'TORQUATA CRUZ DE SOUSA','lickerls@hotmail.com','F',10058,'29166381134'),(60,'JONAS CLAUDIO DE ASSIS','tche_aurelio@hotmail.com','M',10059,'15533166149'),(61,'JOAO PAULINO DE CAMPOS NETO','mrmello@gmail.com','M',10060,'94356599853'),(62,'MARIA RAILENE SANTIAGO PINHEIRO','lickerls@hotmail.com','F',10061,'22104836115'),(63,'EDSON MEDEIRO DA SILVA','tche_aurelio@hotmail.com','M',10062,'34058737115'),(64,'ALDEMIRA FERNANDES DE OLIVEIRA','tche_aurelio@hotmail.com','F',10063,'32483040144'),(65,'ELIZENI DA COSTA LUZ','lickerls@hotmail.com','F',10064,'05891175304'),(66,'LEILA GRARCIENE CORREA DE SOUZA','mrmello@gmail.com','F',10065,'60200359134'),(67,'VALDINEA MATOS DOS SANTOS','mrmello@gmail.com','F',10066,'24914835134'),(68,'ORTENCIA GALBIATI DE OLIVEIRA','lickerls@hotmail.com','F',10067,'18461859120'),(69,'ELCINEIDE AGUIAR DOS SANTOS','mrmello@gmail.com','F',10068,'94139415800'),(70,'ELCINEIDE AGUIAR DOS SANTOS','tche_aurelio@hotmail.com','F',10069,'27997154191'),(71,'RENATO RIBEIRO DE MESQUITA','mrmello@gmail.com','M',10070,'35223154134'),(72,'MARIA ROSSINEIDE BARROS DE MOURA','tche_aurelio@hotmail.com','F',10071,'15421449149'),(73,'GERUZA MACIEL DA SILVA','lickerls@hotmail.com','F',10072,'58451790178'),(74,'RAIMUNDO RODRIGUES DE FREITAS','mrmello@gmail.com','M',10073,'36898457691'),(75,'ALIPIO DA SILVEIRA TORRES','lickerls@hotmail.com','M',10074,'14970767149'),(76,'FRANCISCO ROSEMIRO BARRETO BARROSO','tche_aurelio@hotmail.com','M',10075,'86744518100'),(77,'FRANCISCO FERLENO DE SOUZA','mrmello@gmail.com','M',10076,'60683210106'),(78,'AMILTON VIEIRA','mrmello@gmail.com','M',10077,'15319687168'),(79,'MARIA ALICE GOUVEIA DE OLIVEIRA','lickerls@hotmail.com','F',10078,'26251701153'),(80,'DOMINGOS SALVIO LOPES CABANELAS','tche_aurelio@hotmail.com','M',10079,'18433570110'),(81,'ANTONIO BATISTA VIEIRA','lickerls@hotmail.com','M',10080,'14588790110'),(82,'ROSALI EVARISTO DA SILVA','mrmello@gmail.com','F',10081,'30989418120'),(83,'ECY OLIVEIRA DE CARVALHO','mrmello@gmail.com','F',10082,'37312995187'),(84,'FRANCISCO ALVES DA SILVA','lickerls@hotmail.com','M',10083,'15369803153'),(85,'DANIELA ROCHA DOS SANTOS','lickerls@hotmail.com','F',10084,'22374264149'),(86,'MANOEL DE JESUS BENICIO DA SILVA','tche_aurelio@hotmail.com','M',10085,'24568546168'),(87,'JOAO PEREIRA DOS SANTOS','lickerls@hotmail.com','M',10086,'34341129104'),(88,'FRANCISCA DE OLIVEIRA SILVA','tche_aurelio@hotmail.com','F',10087,'07261560197'),(89,'OSMARINO ANDRADE DO NASCIMENTO','lickerls@hotmail.com','M',10088,'89518748187'),(90,'ROSANGELA LOPES DA SILVA','mrmello@gmail.com','F',10089,'36460753172');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
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
  `cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`id_professor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'Frederico Novaes','frederico.novaes@infnet.edu.br','M','63015825356'),(2,'Tomás de Aquino Tinoco Botelho','aquino.botelho@infnet.edu.br','M','71489227717'),(3,'Rogério Magela','','M','36903471308'),(4,'Bruno Freitas Braga','','M','26344928638'),(5,'Conrad Marques Peres','','M','64583894341'),(6,'André Felix da Silva','','M','18642445181'),(7,'Flavio Longue Guimarães','','M','24844528963'),(8,'Manoel Pedro Sá','','M','27651208110'),(9,'Thiago Medeiros','thiago.medeiros@prof.infnet.edu.br','M','17636766337');
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
  `nome` varchar(100) NOT NULL,
  `id_modulo` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `dt_inicio` datetime DEFAULT NULL,
  `dt_fim` datetime DEFAULT NULL,
  PRIMARY KEY (`id_turma`),
  KEY `id_modulo` (`id_modulo`),
  KEY `id_professor` (`id_professor`),
  CONSTRAINT `turma_ibfk_1` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`),
  CONSTRAINT `turma_ibfk_2` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'Turma 1',2,2,NULL,NULL),(2,'Turma 2',8,6,NULL,NULL),(3,'Turma 3',11,8,NULL,NULL);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_aluno`
--

DROP TABLE IF EXISTS `turma_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma_aluno` (
  `id_turma` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  PRIMARY KEY (`id_turma`,`id_aluno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_aluno`
--

LOCK TABLES `turma_aluno` WRITE;
/*!40000 ALTER TABLE `turma_aluno` DISABLE KEYS */;
INSERT INTO `turma_aluno` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(2,31),(2,32),(2,33),(2,34),(2,35),(2,36),(2,37),(2,38),(2,39),(2,40),(2,41),(2,42),(2,43),(2,44),(2,45),(2,46),(2,47),(2,48),(2,49),(2,50),(2,51),(2,52),(2,53),(2,54),(2,55),(2,56),(2,57),(2,58),(2,59),(2,60),(3,61),(3,62),(3,63),(3,64),(3,65),(3,66),(3,67),(3,68),(3,69),(3,70),(3,71),(3,72),(3,73),(3,74),(3,75),(3,76),(3,77),(3,78),(3,79),(3,80),(3,81),(3,82),(3,83),(3,84),(3,85),(3,86),(3,87),(3,88),(3,89),(3,90);
/*!40000 ALTER TABLE `turma_aluno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-18  1:45:20
