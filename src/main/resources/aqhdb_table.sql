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
-- Table structure for table `attachfile`
--

DROP TABLE IF EXISTS `attachfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attachfile` (
  `fno` int NOT NULL AUTO_INCREMENT,
  `bno` int NOT NULL,
  `uuid` varchar(80) DEFAULT NULL,
  `originName` varchar(100) DEFAULT NULL,
  `uploadPath` varchar(400) DEFAULT NULL,
  `fileSize` int DEFAULT NULL,
  `fmtFileSize` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`fno`),
  KEY `fk_attachfile_board_idx` (`bno`),
  CONSTRAINT `fk_attachfile_board` FOREIGN KEY (`bno`) REFERENCES `board` (`bno`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=238 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `id` varchar(45) NOT NULL,
  `menu` enum('QNA','COMMUNITY','EVENT','NOTICE') DEFAULT NULL,
  `category` enum('QNA_TECH','QNA_CAREER','QNA_ETC','COMMUNITY_LIFE','COMMUNITY_GROUP','EVENT_IT_EVENT','EVENT_MARKETING','NOTICE_NOTICE','NOTICE_EVENT') DEFAULT NULL,
  `readCount` int DEFAULT '0',
  `replyCnt` int DEFAULT '0',
  `files` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `contents` varchar(3000) DEFAULT NULL,
  `writeDay` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bno`),
  KEY `fk_board_member_idx` (`id`),
  CONSTRAINT `fk_board_member` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1938 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `board_file`
--

DROP TABLE IF EXISTS `board_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board_file` (
  `UUID` varchar(500) NOT NULL,
  `F_SEQ` int DEFAULT NULL,
  `ORIGINAL_FILE_NAME` varchar(255) DEFAULT NULL,
  `FILE_PATH` varchar(500) DEFAULT NULL,
  `FILE_SIZE` int DEFAULT NULL,
  `BNO` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(45) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `reg_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `rno` int NOT NULL AUTO_INCREMENT,
  `bno` int NOT NULL,
  `prno` int DEFAULT NULL,
  `writeDay` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `contents` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`rno`),
  KEY `fk_idx` (`bno`),
  KEY `fk_reply_member_idx` (`id`),
  CONSTRAINT `fk_reply_board` FOREIGN KEY (`bno`) REFERENCES `board` (`bno`) ON DELETE CASCADE,
  CONSTRAINT `fk_reply_member` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2640 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-06 14:58:10
