CREATE DATABASE  IF NOT EXISTS `apotdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `apotdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: apotdb
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `komentar`
--

DROP TABLE IF EXISTS `komentar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `komentar` (
  `id_komentar` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lek_id_lek` int(10) unsigned NOT NULL,
  `osoba_id_osoba` int(10) unsigned NOT NULL,
  `komentar` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id_komentar`),
  KEY `komentar_FKIndex1` (`osoba_id_osoba`),
  KEY `komentar_FKIndex2` (`lek_id_lek`),
  CONSTRAINT `komentar_ibfk_1` FOREIGN KEY (`osoba_id_osoba`) REFERENCES `osoba` (`id_osoba`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `komentar_ibfk_2` FOREIGN KEY (`lek_id_lek`) REFERENCES `lek` (`id_lek`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `komentar`
--

LOCK TABLES `komentar` WRITE;
/*!40000 ALTER TABLE `komentar` DISABLE KEYS */;
/*!40000 ALTER TABLE `komentar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `id_korisnik` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_korisnik`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'boris','boris123'),(2,'vuk','vuk123'),(3,'marko','marko123'),(4,'bojan','bojan123');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kupovina`
--

DROP TABLE IF EXISTS `kupovina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kupovina` (
  `id_kupovina` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `osoba_id_osoba` int(10) unsigned NOT NULL,
  `kurirska_sluzba_id_kurirska_sluzba` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_kupovina`),
  KEY `kupovina_FKIndex1` (`kurirska_sluzba_id_kurirska_sluzba`),
  KEY `kupovina_FKIndex2` (`osoba_id_osoba`),
  CONSTRAINT `kupovina_ibfk_1` FOREIGN KEY (`kurirska_sluzba_id_kurirska_sluzba`) REFERENCES `kurirska_sluzba` (`id_kurirska_sluzba`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `kupovina_ibfk_2` FOREIGN KEY (`osoba_id_osoba`) REFERENCES `osoba` (`id_osoba`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kupovina`
--

LOCK TABLES `kupovina` WRITE;
/*!40000 ALTER TABLE `kupovina` DISABLE KEYS */;
INSERT INTO `kupovina` VALUES (1,3,1),(2,3,1);
/*!40000 ALTER TABLE `kupovina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kupovina_has_stavka`
--

DROP TABLE IF EXISTS `kupovina_has_stavka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kupovina_has_stavka` (
  `kupovina_id_kupovina` int(10) unsigned NOT NULL,
  `stavka_id_stavka` int(10) unsigned NOT NULL,
  PRIMARY KEY (`kupovina_id_kupovina`,`stavka_id_stavka`),
  KEY `kupovina_has_stavka_FKIndex1` (`kupovina_id_kupovina`),
  KEY `kupovina_has_stavka_FKIndex2` (`stavka_id_stavka`),
  CONSTRAINT `kupovina_has_stavka_ibfk_1` FOREIGN KEY (`kupovina_id_kupovina`) REFERENCES `kupovina` (`id_kupovina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `kupovina_has_stavka_ibfk_2` FOREIGN KEY (`stavka_id_stavka`) REFERENCES `stavka` (`id_stavka`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kupovina_has_stavka`
--

LOCK TABLES `kupovina_has_stavka` WRITE;
/*!40000 ALTER TABLE `kupovina_has_stavka` DISABLE KEYS */;
INSERT INTO `kupovina_has_stavka` VALUES (1,1),(1,2),(1,3),(2,4),(2,5);
/*!40000 ALTER TABLE `kupovina_has_stavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kurirska_sluzba`
--

DROP TABLE IF EXISTS `kurirska_sluzba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kurirska_sluzba` (
  `id_kurirska_sluzba` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_kurirska_sluzba`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kurirska_sluzba`
--

LOCK TABLES `kurirska_sluzba` WRITE;
/*!40000 ALTER TABLE `kurirska_sluzba` DISABLE KEYS */;
INSERT INTO `kurirska_sluzba` VALUES (1,'BEX Kurirska Sluzba'),(2,'AKS Kurirska Sluzba'),(3,'Postexpress');
/*!40000 ALTER TABLE `kurirska_sluzba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lek`
--

DROP TABLE IF EXISTS `lek`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lek` (
  `id_lek` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `cena` int(10) unsigned DEFAULT NULL,
  `obrisano` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_lek`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lek`
--

LOCK TABLES `lek` WRITE;
/*!40000 ALTER TABLE `lek` DISABLE KEYS */;
INSERT INTO `lek` VALUES (1,'Paracetamol',300,0),(2,'Andol',250,0),(3,'Brufen',180,0),(4,'Septolete',600,0),(5,'Palitrex',150,0),(6,'Pantenol',130,0),(7,'Pantenol krema',290,0),(8,'Propolis kapi',260,0),(9,'Propolis plus',350,0),(10,'Propolis sprej',285,0);
/*!40000 ALTER TABLE `lek` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osoba`
--

DROP TABLE IF EXISTS `osoba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osoba` (
  `id_osoba` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `korisnik_id_korisnik` int(10) unsigned NOT NULL,
  `uloga` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `br_telefona` varchar(255) DEFAULT NULL,
  `godine` int(10) unsigned DEFAULT NULL,
  `grad` varchar(255) DEFAULT NULL,
  `ulica` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_osoba`),
  KEY `osoba_FKIndex1` (`korisnik_id_korisnik`),
  CONSTRAINT `osoba_ibfk_1` FOREIGN KEY (`korisnik_id_korisnik`) REFERENCES `korisnik` (`id_korisnik`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osoba`
--

LOCK TABLES `osoba` WRITE;
/*!40000 ALTER TABLE `osoba` DISABLE KEYS */;
INSERT INTO `osoba` VALUES (1,1,'admin','Boris','Obradovic','0640032123',24,'Novi Sad','Vladimira Nikolica'),(2,2,'admin','Vuk','Jeremic','0640022113',23,'Novi Sad','Vojvodjanska'),(3,3,'korisnik','Marko','Markovic','0611932854',38,'Beograd','Balskanska'),(4,4,'korisnik','Bojan','Ivanovic','0611132258',24,'Beograd','Balkanska 4');
/*!40000 ALTER TABLE `osoba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavka`
--

DROP TABLE IF EXISTS `stavka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stavka` (
  `id_stavka` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lek_id_lek` int(10) unsigned NOT NULL,
  `kolicina` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_stavka`),
  KEY `stavka_FKIndex1` (`lek_id_lek`),
  CONSTRAINT `stavka_ibfk_1` FOREIGN KEY (`lek_id_lek`) REFERENCES `lek` (`id_lek`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavka`
--

LOCK TABLES `stavka` WRITE;
/*!40000 ALTER TABLE `stavka` DISABLE KEYS */;
INSERT INTO `stavka` VALUES (1,1,2),(2,2,2),(3,3,1),(4,4,1),(5,1,1);
/*!40000 ALTER TABLE `stavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavka_has_osoba`
--

DROP TABLE IF EXISTS `stavka_has_osoba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stavka_has_osoba` (
  `stavka_id_stavka` int(10) unsigned NOT NULL,
  `osoba_id_osoba` int(10) unsigned NOT NULL,
  PRIMARY KEY (`stavka_id_stavka`,`osoba_id_osoba`),
  KEY `stavka_has_osoba_FKIndex1` (`stavka_id_stavka`),
  KEY `stavka_has_osoba_FKIndex2` (`osoba_id_osoba`),
  CONSTRAINT `stavka_has_osoba_ibfk_1` FOREIGN KEY (`stavka_id_stavka`) REFERENCES `stavka` (`id_stavka`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stavka_has_osoba_ibfk_2` FOREIGN KEY (`osoba_id_osoba`) REFERENCES `osoba` (`id_osoba`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavka_has_osoba`
--

LOCK TABLES `stavka_has_osoba` WRITE;
/*!40000 ALTER TABLE `stavka_has_osoba` DISABLE KEYS */;
/*!40000 ALTER TABLE `stavka_has_osoba` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-28 18:09:26
