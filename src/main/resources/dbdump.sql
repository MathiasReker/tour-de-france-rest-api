create schema if not exists exam;

use exam;

-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: exam
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `rider`
--

DROP TABLE IF EXISTS `rider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rider` (
  `rider_id` int NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `mountain_point` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_danish_ci DEFAULT NULL,
  `nationality` varchar(255) COLLATE utf8mb4_danish_ci DEFAULT NULL,
  `sprint_point` int NOT NULL,
  `total_time` int NOT NULL,
  `team_id` int DEFAULT NULL,
  PRIMARY KEY (`rider_id`),
  KEY `FK7cbmsvqsue9eaa1p4582x3qer` (`team_id`),
  CONSTRAINT `FK7cbmsvqsue9eaa1p4582x3qer` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rider`
--

LOCK TABLES `rider` WRITE;
/*!40000 ALTER TABLE `rider` DISABLE KEYS */;
INSERT INTO `rider` VALUES (1,25,1,'STORER Michael','Australia',3,104,1),(2,25,2,'GENIETS Kevin','Luxembourg',4,124,1),(3,37,1,'LADAGNOUS Matthieu','France',5,123,1),(4,28,0,'ARMIRAIL Bruno','France',0,155,1),(5,28,2,'LE GAC Olivier','France',10,105,1),(6,29,1,'VERMEERSCH Gianni','Belgium',1,140,2),(7,30,2,'MEURISSE Xandro','Belgium',10,166,2),(8,29,0,'MERLIER Tim','Belgium',0,153,2),(9,27,0,'VAN DER POEL Mathieu','Netherlands',2,150,2),(10,24,2,'PHILIPSEN Jasper','Belgium',1,102,2),(11,28,1,'WÜRTZ SCHMIDT Mads','Denmark',2,101,3),(12,24,1,'GOLDSTEIN Omer','Israel',1,140,3),(13,35,0,'WOODS Michael','Canada',0,140,2),(14,37,0,'FROOME Chris','Nairobi',1,145,3),(15,37,1,'FUGLSANG Jakob','Denmark',1,123,2);
/*!40000 ALTER TABLE `rider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `team_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_danish_ci DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE KEY `UK_g2l9qqsoeuynt4r5ofdt1x2td` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (2,'Alpecin-Deceuninck'),(1,'Groupama - FDJ'),(3,'Israel - Premier Tech');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-31  3:03:04
