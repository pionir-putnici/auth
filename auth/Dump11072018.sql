-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: websystique
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
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `first_name` varchar(30) COLLATE utf8_bin NOT NULL,
  `last_name` varchar(30) COLLATE utf8_bin NOT NULL,
  `email` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user_user_profile`
--

DROP TABLE IF EXISTS `app_user_user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user_user_profile`
--

LOCK TABLES `app_user_user_profile` WRITE;
/*!40000 ALTER TABLE `app_user_user_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_user_user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artikli`
--

DROP TABLE IF EXISTS `artikli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artikli` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vrste_artikala_naziv` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `jedinice_mera_id` bigint(20) DEFAULT NULL,
  `klasifikacije_id` bigint(20) DEFAULT NULL,
  `poreske_grupe_id` bigint(20) DEFAULT NULL,
  `vrste_artikala_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hx9k3ibbioo4m5s479s00cbk` (`jedinice_mera_id`),
  KEY `FK_8mh3tpfyftgsnquy9hnmqh1k5` (`klasifikacije_id`),
  KEY `FK_jiwsomivwprpfpnhe14jsw3c` (`poreske_grupe_id`),
  KEY `FK_ptdpcc74ldpm54pf3liua6brt` (`vrste_artikala_id`),
  CONSTRAINT `FK_8mh3tpfyftgsnquy9hnmqh1k5` FOREIGN KEY (`klasifikacije_id`) REFERENCES `klasifikacije` (`id`),
  CONSTRAINT `FK_hx9k3ibbioo4m5s479s00cbk` FOREIGN KEY (`jedinice_mera_id`) REFERENCES `jedinice_mera` (`id`),
  CONSTRAINT `FK_jiwsomivwprpfpnhe14jsw3c` FOREIGN KEY (`poreske_grupe_id`) REFERENCES `poreske_grupe` (`id`),
  CONSTRAINT `FK_ptdpcc74ldpm54pf3liua6brt` FOREIGN KEY (`vrste_artikala_id`) REFERENCES `vrste_artikala` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artikli`
--

LOCK TABLES `artikli` WRITE;
/*!40000 ALTER TABLE `artikli` DISABLE KEYS */;
INSERT INTO `artikli` VALUES (7,NULL,'','2',NULL,NULL,'Euro paleta sa svim žigovima 800x120mm kvalitet A','',NULL,'2018-07-03 14:23:15',NULL,NULL,NULL,8,2,1,1),(8,NULL,'','1',NULL,NULL,'Euro paleta sa svim žigovima 800x120mm kvalitet B','',NULL,'2018-07-03 14:22:58',NULL,NULL,NULL,8,2,1,1),(9,NULL,'','3',NULL,NULL,'Kvalitet Euro palete bez žigova 800x1200mm','390 rsd/kom',NULL,'2018-07-03 14:24:47',NULL,NULL,NULL,8,2,1,1),(10,NULL,'','4',NULL,NULL,'Kvalitet Euro palete bez žigova 1000x1200mm','390 rsd/kom',NULL,'2018-07-03 14:26:46',NULL,NULL,NULL,8,2,1,1),(11,NULL,'','5',NULL,NULL,'Euro dimenzija slaba građa 800x1200mm','170 rsd/kom\r\n',NULL,'2018-07-03 14:25:59',NULL,NULL,NULL,8,2,1,1),(12,NULL,'','6',NULL,NULL,'Euro dimenzija slaba građa 1000x1200mm','170 rsd/kom',NULL,'2018-07-03 14:26:35',NULL,NULL,NULL,8,2,1,1),(13,NULL,'','7',NULL,NULL,'Otpad drvo','6 rsd/kg',NULL,'2018-07-03 14:27:54',NULL,NULL,NULL,1,6,1,11);
/*!40000 ALTER TABLE `artikli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dokument`
--

DROP TABLE IF EXISTS `dokument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dokument` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `broj_prijemnice` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `broj_dokumenta` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `id_komitent` bigint(20) DEFAULT NULL,
  `id_magacin` bigint(20) DEFAULT NULL,
  `id_vrsta_dokumenta` bigint(20) DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `iznos` decimal(19,2) DEFAULT NULL,
  `porez` decimal(19,2) DEFAULT NULL,
  `iznos_bez_poreza` decimal(19,2) DEFAULT NULL,
  `akcija` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `datum_vreme` datetime DEFAULT NULL,
  `host` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `interni_broj_dokumenta` int(11) DEFAULT NULL,
  `osnov` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `predao` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `primio` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `id_magacin2` bigint(20) DEFAULT NULL,
  `id_komitent2` bigint(20) DEFAULT NULL,
  `id_vrsta_dokumenta2` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_d3kcanfu9i80qm57i6tgl9h62` (`id_vrsta_dokumenta`),
  KEY `FK_75e9tn2lda8bl4rotwprpeef5` (`id_komitent`),
  KEY `FK_s2uykiec68hcoenca0tb72euj` (`id_komitent2`),
  KEY `FK_eqv4mke8gijgpymjqdtw20w7t` (`id_vrsta_dokumenta2`),
  CONSTRAINT `FK_75e9tn2lda8bl4rotwprpeef5` FOREIGN KEY (`id_komitent`) REFERENCES `partner` (`id`),
  CONSTRAINT `FK_d3kcanfu9i80qm57i6tgl9h62` FOREIGN KEY (`id_vrsta_dokumenta`) REFERENCES `types_of_documents` (`id`),
  CONSTRAINT `FK_eqv4mke8gijgpymjqdtw20w7t` FOREIGN KEY (`id_vrsta_dokumenta2`) REFERENCES `types_of_documents` (`id`),
  CONSTRAINT `FK_s2uykiec68hcoenca0tb72euj` FOREIGN KEY (`id_komitent2`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dokument`
--

LOCK TABLES `dokument` WRITE;
/*!40000 ALTER TABLE `dokument` DISABLE KEYS */;
INSERT INTO `dokument` VALUES (2,NULL,'ert','2018-01-10',1,17,1,'aaaaa',442.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-06-05 13:11:26',NULL,33,NULL,NULL,NULL,NULL,NULL,NULL),(3,NULL,'44','2018-01-05',1,17,1,'',200.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-02-14 10:37:50',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,'43','2018-01-24',1,15,1,'asdf',135.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-01-06 18:20:32',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,'77','2018-02-08',1,15,2,'asdfsad',50.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-02-08 13:26:58',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,'0802','2018-02-08',3,15,2,'asdf',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-02-08 14:42:03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,'10','2018-02-12',2,15,1,'napomena',170.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-05-30 14:57:40',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,'14','2018-06-19',1,21,1,'ova napomena',25.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-06-19 14:39:37',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,NULL,'','2018-06-25',2,17,1,'',8.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-06-25 10:55:42',NULL,34,NULL,NULL,NULL,NULL,NULL,NULL),(10,NULL,'PR-001','2018-06-25',1,21,1,'',150.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-06-25 10:02:22',NULL,35,NULL,NULL,NULL,NULL,NULL,NULL),(11,NULL,'1','2018-06-25',1,21,1,'',31.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-06-25 10:02:02',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(12,NULL,'11','2018-06-25',4,28,2,'',33.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-07-02 11:42:06',NULL,1,'Faktura bb','Boza','Misko',NULL,NULL,NULL),(13,NULL,'12','2018-07-06',1,15,1,'asdf',132.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-07-06 11:29:00',NULL,36,'','Boza','',NULL,NULL,NULL),(14,NULL,'1234','2018-07-06',1,24,1,'',132.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-07-10 11:03:38',NULL,37,'','','',19,NULL,NULL),(15,NULL,'t','2018-07-11',4,23,6,'',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-07-11 15:43:41',NULL,1,'','Krsta','Pedja',24,4,7),(16,NULL,'16','2018-07-10',1,23,1,'1',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-07-10 12:33:57',NULL,38,'','Dejan','Krsta',19,NULL,NULL),(17,NULL,'33','2018-07-10',1,27,1,'',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-07-10 12:37:52',NULL,39,'','','',15,NULL,NULL),(18,NULL,'88','2018-07-10',1,25,1,'',150.00,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'2018-07-10 13:25:30',NULL,40,'','Boza','Pedja',19,NULL,NULL);
/*!40000 ALTER TABLE `dokument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dokument_stavke`
--

DROP TABLE IF EXISTS `dokument_stavke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dokument_stavke` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `id_dokument` bigint(20) DEFAULT NULL,
  `id_magacin` bigint(20) DEFAULT NULL,
  `id_roba` bigint(20) DEFAULT NULL,
  `roba_naziv` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `id_vrsta_dokumenta` bigint(20) DEFAULT NULL,
  `kolicina` decimal(19,2) DEFAULT NULL,
  `ulaz` decimal(19,2) DEFAULT NULL,
  `izlaz` decimal(19,2) DEFAULT NULL,
  `cena` decimal(19,2) DEFAULT NULL,
  `duguje` decimal(19,2) DEFAULT NULL,
  `potrazuje` decimal(19,2) DEFAULT NULL,
  `iznos` decimal(19,2) DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `datumvreme` datetime DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `akcija` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `host` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `dokument_stavkecol` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `povratna` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_7rerlj1gft3p0qn5wrl1b46ju` (`id_dokument`),
  KEY `FK_qxmrqcev02dsx7w0l3fp2c0uj` (`id_vrsta_dokumenta`),
  KEY `FK_dngbsx9u2ns83h5my0wo9n3m6` (`id_roba`),
  CONSTRAINT `FK_7rerlj1gft3p0qn5wrl1b46ju` FOREIGN KEY (`id_dokument`) REFERENCES `dokument` (`id`),
  CONSTRAINT `FK_dngbsx9u2ns83h5my0wo9n3m6` FOREIGN KEY (`id_roba`) REFERENCES `artikli` (`id`),
  CONSTRAINT `FK_qxmrqcev02dsx7w0l3fp2c0uj` FOREIGN KEY (`id_vrsta_dokumenta`) REFERENCES `types_of_documents` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dokument_stavke`
--

LOCK TABLES `dokument_stavke` WRITE;
/*!40000 ALTER TABLE `dokument_stavke` DISABLE KEYS */;
INSERT INTO `dokument_stavke` VALUES (4,'2018-04-01',2,15,8,NULL,1,10.00,10.00,0.00,12.00,120.00,0.00,120.00,NULL,NULL,'',NULL,NULL,NULL,1),(5,'2018-05-01',2,15,7,NULL,1,10.00,15.00,0.00,15.00,0.00,150.00,12.00,NULL,NULL,'',NULL,NULL,NULL,1),(7,'2018-04-14',NULL,15,7,NULL,1,14.00,10.00,2.00,14.00,0.00,0.00,14.00,NULL,NULL,'',NULL,NULL,NULL,1),(8,'2018-03-03',2,15,7,NULL,1,12.00,30.00,0.00,12.00,0.00,0.00,12.00,NULL,NULL,'',NULL,NULL,NULL,1),(9,'2018-01-10',2,15,7,NULL,1,15.00,44.00,10.00,15.00,0.00,0.00,15.00,NULL,NULL,'',NULL,NULL,NULL,1),(10,'2018-02-02',2,NULL,7,NULL,1,44.00,0.00,15.00,44.00,0.00,0.00,44.00,NULL,NULL,'',NULL,NULL,NULL,1),(11,NULL,2,15,7,NULL,NULL,3.00,0.00,0.00,3.00,0.00,0.00,3.00,NULL,NULL,'',NULL,NULL,NULL,1),(12,NULL,2,15,7,NULL,NULL,3.00,0.00,0.00,3.00,0.00,0.00,3.00,NULL,NULL,'',NULL,NULL,NULL,1),(13,NULL,3,NULL,7,NULL,NULL,3.00,0.00,0.00,33.00,0.00,0.00,3.00,NULL,NULL,'',NULL,NULL,NULL,1),(14,NULL,2,15,7,NULL,NULL,2.00,0.00,0.00,22.00,0.00,0.00,33.00,NULL,NULL,'',NULL,NULL,NULL,1),(15,'2018-05-29',4,15,8,NULL,NULL,4.00,0.00,4.00,10.00,0.00,40.00,40.00,NULL,NULL,'',NULL,NULL,NULL,1),(16,NULL,4,15,7,NULL,NULL,3.00,0.00,0.00,3.00,0.00,0.00,3.00,NULL,NULL,'',NULL,NULL,NULL,1),(17,NULL,6,15,8,NULL,2,3.00,0.00,0.00,3.00,0.00,0.00,3.00,NULL,NULL,'',NULL,NULL,NULL,1),(19,NULL,6,15,7,NULL,2,0.00,0.00,0.00,NULL,0.00,0.00,0.00,NULL,NULL,'',NULL,NULL,NULL,1),(20,'2018-05-12',6,15,9,NULL,2,1.00,0.00,0.00,1.00,0.00,0.00,1.00,NULL,NULL,'',NULL,NULL,NULL,1),(22,'2018-05-11',2,15,8,NULL,1,44.00,0.00,44.00,4.00,186.00,0.00,186.00,NULL,NULL,'',NULL,NULL,NULL,1),(23,'2018-01-10',2,15,9,NULL,1,2.00,0.00,0.00,2.00,0.00,0.00,2.00,NULL,'2018-05-30 14:57:56','',NULL,NULL,NULL,1),(24,NULL,5,15,8,NULL,2,444.00,0.00,0.00,1.00,0.00,0.00,1.00,NULL,NULL,'',NULL,NULL,NULL,1),(25,NULL,5,15,9,NULL,2,44.00,0.00,0.00,4.00,0.00,0.00,4.00,NULL,NULL,'',NULL,NULL,NULL,1),(26,NULL,7,15,7,NULL,1,10.00,0.00,0.00,10.00,0.00,0.00,10.00,NULL,NULL,'',NULL,NULL,NULL,1),(27,NULL,7,15,9,NULL,1,10.00,0.00,0.00,10.00,0.00,0.00,10.00,NULL,NULL,'',NULL,NULL,NULL,1),(28,'2018-02-12',7,15,8,NULL,1,14.00,0.00,0.00,15.00,0.00,0.00,150.00,NULL,'2018-05-30 14:57:40','',NULL,NULL,NULL,1),(30,'2018-06-19',8,21,8,NULL,1,10.00,10.00,0.00,11.00,11.00,0.00,11.00,NULL,'2018-06-19 14:39:10','',NULL,NULL,NULL,1),(32,'2018-06-18',8,19,7,NULL,1,12.00,12.00,0.00,14.00,14.00,0.00,14.00,NULL,'2018-06-18 12:49:57','',NULL,NULL,NULL,1),(33,'2018-06-15',10,19,7,NULL,1,10.00,10.00,0.00,15.00,150.00,0.00,150.00,NULL,'2018-06-15 12:51:14','',NULL,NULL,NULL,1),(38,'2018-06-25',11,21,7,NULL,1,1.00,1.00,NULL,11.00,11.00,NULL,11.00,NULL,'2018-07-02 13:41:33','',NULL,NULL,NULL,0),(39,'2018-06-25',11,21,8,NULL,1,5.00,5.00,NULL,4.00,20.00,NULL,20.00,NULL,'2018-07-02 13:41:24','',NULL,NULL,NULL,0),(40,'2018-06-25',12,28,7,NULL,2,1.00,NULL,1.00,33.00,NULL,33.00,33.00,NULL,'2018-07-02 15:26:59','',NULL,NULL,NULL,0),(41,'2018-06-25',9,17,7,NULL,1,2.00,2.00,0.00,4.00,8.00,0.00,8.00,NULL,'2018-06-25 10:55:42','',NULL,NULL,NULL,1),(42,'2018-07-06',13,15,7,NULL,1,11.00,11.00,NULL,12.00,132.00,NULL,132.00,NULL,'2018-07-06 11:28:59','',NULL,NULL,NULL,1),(43,'2018-07-06',14,19,7,NULL,1,11.00,11.00,NULL,12.00,132.00,NULL,132.00,NULL,'2018-07-06 13:37:45','',NULL,NULL,NULL,1),(44,'2018-07-10',18,25,8,NULL,1,10.00,10.00,NULL,15.00,150.00,NULL,150.00,NULL,'2018-07-10 13:25:01','',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `dokument_stavke` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drzave`
--

DROP TABLE IF EXISTS `drzave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drzave` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `slike` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drzave`
--

LOCK TABLES `drzave` WRITE;
/*!40000 ALTER TABLE `drzave` DISABLE KEYS */;
INSERT INTO `drzave` VALUES (0,NULL,'','0','-',NULL,'2017-12-25 18:36:18',NULL,NULL,NULL,NULL),(9,NULL,'','0','Slovenija','','2018-07-10 10:36:45',NULL,NULL,NULL,NULL),(10,NULL,'','8','Crna Gora','','2018-07-10 10:36:34',NULL,NULL,NULL,NULL),(11,NULL,'','11','Srbija','','2018-07-10 10:35:38',NULL,NULL,NULL,NULL),(12,NULL,'','10','Hrvatska','','2018-07-10 10:36:20',NULL,NULL,NULL,NULL),(13,NULL,'','15','UAE','','2017-12-31 19:03:44',NULL,NULL,NULL,NULL),(14,NULL,'','16','BIH','','2018-07-10 10:36:04',NULL,NULL,NULL,NULL),(15,NULL,'','18','Makedonija','','2018-07-10 10:35:55',NULL,NULL,NULL,NULL),(16,NULL,'','19','Holandija','','2017-12-31 19:04:37',NULL,NULL,NULL,NULL),(17,NULL,'','20','Bugarska','','2018-07-10 10:36:56',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `drzave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hellolog`
--

DROP TABLE IF EXISTS `hellolog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hellolog` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hellolog`
--

LOCK TABLES `hellolog` WRITE;
/*!40000 ALTER TABLE `hellolog` DISABLE KEYS */;
/*!40000 ALTER TABLE `hellolog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jedinice_mera`
--

DROP TABLE IF EXISTS `jedinice_mera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jedinice_mera` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jedinice_mera`
--

LOCK TABLES `jedinice_mera` WRITE;
/*!40000 ALTER TABLE `jedinice_mera` DISABLE KEYS */;
INSERT INTO `jedinice_mera` VALUES (1,NULL,'','1','kg','k','2017-12-05 10:32:24'),(2,NULL,'','2','m','','2017-12-05 12:14:19'),(3,NULL,'','3','l','','2017-12-05 12:16:00'),(4,NULL,'','4','m2','m21','2017-12-05 12:20:13'),(5,NULL,'','5','t','85','2017-12-05 12:20:47'),(6,NULL,'','0','-','','2017-12-10 17:36:07'),(7,NULL,'','m3','Metar kubni','','2018-05-30 13:22:28'),(8,NULL,'','6','Komad','','2018-06-19 14:49:43');
/*!40000 ALTER TABLE `jedinice_mera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klasifikacije`
--

DROP TABLE IF EXISTS `klasifikacije`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klasifikacije` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klasifikacije`
--

LOCK TABLES `klasifikacije` WRITE;
/*!40000 ALTER TABLE `klasifikacije` DISABLE KEYS */;
INSERT INTO `klasifikacije` VALUES (2,NULL,'','1','Palete','','2018-07-03 14:21:20'),(5,NULL,'','0','-','','2017-12-10 17:35:27'),(6,NULL,'','3','Ambalaža','','2018-07-03 14:21:00');
/*!40000 ALTER TABLE `klasifikacije` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magacini`
--

DROP TABLE IF EXISTS `magacini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magacini` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aktivan` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vrste_magacina_id` int(11) DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vrste_magacina_naziv` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `partner_id` bigint(20) DEFAULT NULL,
  `adresa` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ptt_id` bigint(20) DEFAULT NULL,
  `objekat` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_66uqm8qh2v9whhyc62s5mbu52` (`vrste_magacina_id`),
  KEY `FK_lvpft8knmxuaq8llorp25f867` (`partner_id`),
  KEY `FK_7j6yepm5aoye6xq56kyxt96qs` (`ptt_id`),
  CONSTRAINT `FK_66uqm8qh2v9whhyc62s5mbu52` FOREIGN KEY (`vrste_magacina_id`) REFERENCES `vrste_magacina` (`id`),
  CONSTRAINT `FK_lvpft8knmxuaq8llorp25f867` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magacini`
--

LOCK TABLES `magacini` WRITE;
/*!40000 ALTER TABLE `magacini` DISABLE KEYS */;
INSERT INTO `magacini` VALUES (0,'','-',5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,5,'\0'),(15,'','DELHAIZE TEMPO 001 VILINE VODE',5,NULL,'1','sadf','2018-07-10 08:05:53',NULL,NULL,NULL,NULL,1,'Viline vode',5,'\0'),(17,'','Maloprodaja',6,NULL,'2','vf','2018-06-14 11:15:14',NULL,NULL,NULL,NULL,2,'Bozanova 4',5,'\0'),(19,'','DELHAIZE M 831 SERBIA CENTRALNI STARA PAZOVA',5,NULL,'3','','2018-06-19 14:33:45',NULL,NULL,NULL,NULL,1,'Auto put bb',5,'\0'),(21,'','DELHAIZE TEMPO 011 ADA',5,NULL,'4','','2018-06-19 14:36:16',NULL,NULL,NULL,NULL,1,'Ada bb',4,'\0'),(23,'','Čokolada PJ Subotica',7,NULL,'5','','2018-07-10 10:40:59',NULL,NULL,NULL,NULL,4,'Senćanski put 83',4,''),(24,'','Bombon PJ Subotica',7,NULL,'6','','2018-07-10 08:51:20',NULL,NULL,NULL,NULL,4,'Senćanski put 83',4,''),(25,'','Pecivo PJ Subotica',7,NULL,'7','','2018-07-10 08:51:12',NULL,NULL,NULL,NULL,4,'Senćanski put 83',4,''),(26,'','Magacin sirovina',8,NULL,'8','','2018-07-10 08:51:01',NULL,NULL,NULL,NULL,4,'Senćanski put 83',4,''),(27,'','Magacin gotove robe',8,NULL,'9','','2018-07-10 08:50:55',NULL,NULL,NULL,NULL,4,'Senćanski put 83',4,''),(28,'','Magacin otpada',8,NULL,'10','','2018-07-10 08:50:45',NULL,NULL,NULL,NULL,4,'Senćanski put 83',4,''),(29,'','Magacin korisnog otpada',5,NULL,'11','','2018-07-10 08:50:36',NULL,NULL,NULL,NULL,4,'Senćanski put 83',4,''),(30,'','Magacin Milšped Krnješevci',5,NULL,'12','','2018-07-10 10:38:50',NULL,NULL,NULL,NULL,5,'BB',7,'\0'),(31,'','Metro Subotica',5,NULL,'13','','2018-07-11 14:52:28',NULL,NULL,NULL,NULL,3,'Palicki put',4,'\0');
/*!40000 ALTER TABLE `magacini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partner`
--

DROP TABLE IF EXISTS `partner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `adresa` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `asoft_sifra` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `maticni_broj` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pib` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `telefon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ptt_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_549l2rpeqe89sccpqf2g4x4aq` (`ptt_id`),
  CONSTRAINT `FK_549l2rpeqe89sccpqf2g4x4aq` FOREIGN KEY (`ptt_id`) REFERENCES `ptt_brojevi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner`
--

LOCK TABLES `partner` WRITE;
/*!40000 ALTER TABLE `partner` DISABLE KEYS */;
INSERT INTO `partner` VALUES (0,NULL,'-',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,5),(1,'1','DELHAIZE',NULL,NULL,NULL,'123','',NULL,'2018-06-19 14:27:24','',NULL,NULL,NULL,NULL,5),(2,'2','DIS ',NULL,NULL,NULL,'','',NULL,'2018-06-19 15:00:18','',NULL,NULL,NULL,NULL,5),(3,'3','Metro',NULL,NULL,NULL,'','',NULL,'2018-06-19 15:00:55','',NULL,NULL,NULL,NULL,5),(4,'4','Pionir Subotica',NULL,NULL,NULL,'17450689','',NULL,'2018-07-10 10:30:53','',NULL,NULL,NULL,NULL,5),(5,'5','Milšped d.o.o.',NULL,NULL,NULL,'1','',NULL,'2018-07-10 10:31:23','',NULL,NULL,NULL,NULL,5);
/*!40000 ALTER TABLE `partner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partner_magacini`
--

DROP TABLE IF EXISTS `partner_magacini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partner_magacini` (
  `partner` bigint(20) NOT NULL,
  `magacini` bigint(20) NOT NULL,
  UNIQUE KEY `UK_9jp6f4w7lnyqdvjso2x1p1tyn` (`magacini`),
  KEY `FK_35w4gqw42w9ubd6pw4uxelito` (`partner`),
  CONSTRAINT `FK_35w4gqw42w9ubd6pw4uxelito` FOREIGN KEY (`partner`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner_magacini`
--

LOCK TABLES `partner_magacini` WRITE;
/*!40000 ALTER TABLE `partner_magacini` DISABLE KEYS */;
/*!40000 ALTER TABLE `partner_magacini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `series` varchar(64) COLLATE utf8_bin NOT NULL,
  `token` varchar(64) COLLATE utf8_bin NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poreske_grupe`
--

DROP TABLE IF EXISTS `poreske_grupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poreske_grupe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `stopa` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poreske_grupe`
--

LOCK TABLES `poreske_grupe` WRITE;
/*!40000 ALTER TABLE `poreske_grupe` DISABLE KEYS */;
INSERT INTO `poreske_grupe` VALUES (1,'20 %',NULL,'','1','20 %','2017-12-06 11:39:12',20),(2,'-',NULL,'','0','','2017-12-10 17:35:55',0);
/*!40000 ALTER TABLE `poreske_grupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prijemnica`
--

DROP TABLE IF EXISTS `prijemnica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prijemnica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `broj_prijemnice` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `datum_vreme` datetime DEFAULT NULL,
  `host` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `id_komitent` int(11) DEFAULT NULL,
  `id_magacin` int(11) DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prijemnica`
--

LOCK TABLES `prijemnica` WRITE;
/*!40000 ALTER TABLE `prijemnica` DISABLE KEYS */;
/*!40000 ALTER TABLE `prijemnica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prijemnica_stavke`
--

DROP TABLE IF EXISTS `prijemnica_stavke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prijemnica_stavke` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `cena` decimal(19,2) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `datumvreme` datetime DEFAULT NULL,
  `host` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `id_roba` int(11) DEFAULT NULL,
  `izlaz` decimal(19,2) DEFAULT NULL,
  `iznos` decimal(19,2) DEFAULT NULL,
  `kolicina` decimal(19,2) DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `prijemnica_stavkecol` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `roba_naziv` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ulaz` decimal(19,2) DEFAULT NULL,
  `id_prijemnica` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5hfntdhgrswoxkm7ev13t0utl` (`id_prijemnica`),
  CONSTRAINT `FK_5hfntdhgrswoxkm7ev13t0utl` FOREIGN KEY (`id_prijemnica`) REFERENCES `prijemnica` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prijemnica_stavke`
--

LOCK TABLES `prijemnica_stavke` WRITE;
/*!40000 ALTER TABLE `prijemnica_stavke` DISABLE KEYS */;
/*!40000 ALTER TABLE `prijemnica_stavke` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_45g3a4rexapplpirj3jor716p` (`company_id`),
  CONSTRAINT `FK_45g3a4rexapplpirj3jor716p` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptt_brojevi`
--

DROP TABLE IF EXISTS `ptt_brojevi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptt_brojevi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `drzava_naziv` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ptt_brojevi_id` bigint(20) DEFAULT NULL,
  `drzava_id` bigint(20) DEFAULT NULL,
  `adresa` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `asoft_sifra` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `maticni_broj` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pib` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ptt_broj_id` bigint(20) DEFAULT NULL,
  `ptt_broj_naziv` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `telefon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_299429h6eh3yovmkodsy1necx` (`ptt_brojevi_id`),
  CONSTRAINT `FK_299429h6eh3yovmkodsy1necx` FOREIGN KEY (`ptt_brojevi_id`) REFERENCES `drzave` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptt_brojevi`
--

LOCK TABLES `ptt_brojevi` WRITE;
/*!40000 ALTER TABLE `ptt_brojevi` DISABLE KEYS */;
INSERT INTO `ptt_brojevi` VALUES (0,NULL,'','0',NULL,'-',NULL,NULL,NULL,NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,'','24000',NULL,'Subotica','',NULL,'2018-06-19 14:27:05',NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,'','11000',NULL,'Beograd','0',NULL,'2018-06-19 14:26:46',NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,'','3',NULL,'Krnješevci','',NULL,'2018-07-10 10:35:02',NULL,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ptt_brojevi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptt_brojevi_partners`
--

DROP TABLE IF EXISTS `ptt_brojevi_partners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptt_brojevi_partners` (
  `ptt_brojevi` bigint(20) NOT NULL,
  `partners` bigint(20) NOT NULL,
  UNIQUE KEY `UK_8shg0a1cpnybu775wyld9439p` (`partners`),
  KEY `FK_gwg1refcw25vo6y6td4uf7l2l` (`ptt_brojevi`),
  CONSTRAINT `FK_8shg0a1cpnybu775wyld9439p` FOREIGN KEY (`partners`) REFERENCES `partner` (`id`),
  CONSTRAINT `FK_gwg1refcw25vo6y6td4uf7l2l` FOREIGN KEY (`ptt_brojevi`) REFERENCES `ptt_brojevi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptt_brojevi_partners`
--

LOCK TABLES `ptt_brojevi_partners` WRITE;
/*!40000 ALTER TABLE `ptt_brojevi_partners` DISABLE KEYS */;
/*!40000 ALTER TABLE `ptt_brojevi_partners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types_of_documents`
--

DROP TABLE IF EXISTS `types_of_documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `types_of_documents` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `strana` bigint(20) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types_of_documents`
--

LOCK TABLES `types_of_documents` WRITE;
/*!40000 ALTER TABLE `types_of_documents` DISABLE KEYS */;
INSERT INTO `types_of_documents` VALUES (0,'0','-',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL),(1,'1','Prijemnica povratna','Prijemnica povratna',NULL,'2018-07-09 09:18:17',NULL,NULL,1,'1','',NULL),(2,'2','Otpremnica povratna','Otpremnica povratna',NULL,'2018-07-09 09:18:09',NULL,NULL,2,'1','',NULL),(3,'3','Prijemnica nepovratna','Prijemnica nepovratna',NULL,'2018-07-09 09:18:03',NULL,NULL,1,'1','',NULL),(4,'4','Otpremnica nepovratna','Otpremnica nepovratna',NULL,'2018-07-09 09:17:56',NULL,NULL,2,'1','',NULL),(5,'5','Otpis','Otpis',NULL,'2018-07-09 10:32:03',NULL,NULL,2,'1','',NULL),(6,'6','Medjumagacinski prijem','',NULL,'2018-07-09 10:32:36',NULL,NULL,1,'2','',NULL),(7,'7','Medjumagacinski izlaz','',NULL,'2018-07-09 10:39:46',NULL,NULL,2,'2','',NULL);
/*!40000 ALTER TABLE `types_of_documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$8hn2khFGTjBjU45Ssi8zdu/Zg1PoRjxFPh/hFDLt.V3BhNWRdwlQq','user'),(2,'$2a$10$yTZQLBwc8MJdFkh9mDpwpeFrTDnvsuOZcrkLATbz7hanhI9rGkIBO','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vrste_artikala`
--

DROP TABLE IF EXISTS `vrste_artikala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vrste_artikala` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vrste_artikala`
--

LOCK TABLES `vrste_artikala` WRITE;
/*!40000 ALTER TABLE `vrste_artikala` DISABLE KEYS */;
INSERT INTO `vrste_artikala` VALUES (1,'Palete',NULL,'','1','11','2018-06-19 14:45:10'),(10,'-',NULL,'','0','','2017-12-10 17:35:43'),(11,'Otpad',NULL,'','2','','2018-06-19 14:45:20'),(12,'Razno',NULL,'','2','','2018-06-19 14:45:36');
/*!40000 ALTER TABLE `vrste_artikala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vrste_magacina`
--

DROP TABLE IF EXISTS `vrste_magacina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vrste_magacina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) NOT NULL,
  `timestamp` datetime DEFAULT NULL,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vrste_magacina`
--

LOCK TABLES `vrste_magacina` WRITE;
/*!40000 ALTER TABLE `vrste_magacina` DISABLE KEYS */;
INSERT INTO `vrste_magacina` VALUES (5,'Veleprodaja','','2017-12-08 19:30:40',NULL,'1',''),(6,'Maloprodaja','','2018-01-08 18:51:23',NULL,'2',''),(7,'Poslovna jedinica','','2018-06-19 14:54:52',NULL,'3',''),(8,'Magacin','','2018-06-19 14:57:27',NULL,'4','');
/*!40000 ALTER TABLE `vrste_magacina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vrste_paleta`
--

DROP TABLE IF EXISTS `vrste_paleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vrste_paleta` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` tinyint(1) DEFAULT '1',
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vrste_paleta`
--

LOCK TABLES `vrste_paleta` WRITE;
/*!40000 ALTER TABLE `vrste_paleta` DISABLE KEYS */;
/*!40000 ALTER TABLE `vrste_paleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vrste_paleta_old`
--

DROP TABLE IF EXISTS `vrste_paleta_old`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vrste_paleta_old` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `aktivan` tinyint(1) DEFAULT '1',
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `akcija` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vrste_paleta_old`
--

LOCK TABLES `vrste_paleta_old` WRITE;
/*!40000 ALTER TABLE `vrste_paleta_old` DISABLE KEYS */;
/*!40000 ALTER TABLE `vrste_paleta_old` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zapisnici`
--

DROP TABLE IF EXISTS `zapisnici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zapisnici` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `akcija` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `predao` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `primio` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `video` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zvuk` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dokument_id` bigint(20) DEFAULT NULL,
  `slika_zapisnika` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mw06vqmuo2rxnxlg3syi7bsvg` (`dokument_id`),
  CONSTRAINT `FK_mw06vqmuo2rxnxlg3syi7bsvg` FOREIGN KEY (`dokument_id`) REFERENCES `dokument` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zapisnici`
--

LOCK TABLES `zapisnici` WRITE;
/*!40000 ALTER TABLE `zapisnici` DISABLE KEYS */;
INSERT INTO `zapisnici` VALUES (2,NULL,NULL,NULL,'a','b','asdfasdf',NULL,'2018-07-05 13:07:14',NULL,NULL,11,NULL),(3,NULL,NULL,NULL,'a','b','',NULL,'2018-07-05 13:14:49',NULL,NULL,11,NULL);
/*!40000 ALTER TABLE `zapisnici` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-11 15:57:22
