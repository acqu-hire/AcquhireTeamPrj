-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aqhdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(16) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `reg_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('','','',NULL,'   ','','','2023-01-11 01:01:17'),('aaaa','1234','차차차','F','제주특별자치도 서귀포시 가가로 14','01033332222','11111@naver.com','2023-01-03 12:43:06'),('aabb','12341234','김시형','M','경기 의정부시 가금로34번길 23','01033331111','aaa@naver.com','2023-01-11 11:48:34'),('abc','1234','차차차','F','제주특별자치도 서귀포시 가가로 14','01033332222','11111@naver.com','2023-01-03 10:11:05'),('abcd','1234','차차차','M','제주특별자치도 서귀포시 가가로 14','01033332222','11111@naver.com','2023-01-03 10:07:16'),('aqaq','1234','차차차','F','제주특별자치도 서귀포시 가가로 14','01033332222','11111@naver.com','2023-01-03 10:12:16'),('asdf','1234','차차차','F','제주특별자치도 서귀포시 가가로 14','01033332222','11111@naver.com','2023-01-03 12:42:52'),('bacd','1234','차차차','M','제주특별자치도 서귀포시 가가로 14','01033332222','11111@naver.com','2023-01-03 10:08:14'),('bbb111','12341234','차차차','M','제주특별자치도 서귀포시 가가로 14','01033332222','11111@naver.com','2023-01-10 22:50:26'),('fly123','12341234','차차차','M','제주특별자치도 서귀포시 가가로 14','01033332222','11111@naver.com','2023-01-10 22:52:28');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-13 12:32:19
