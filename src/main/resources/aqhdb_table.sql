-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aqhdb
-- ------------------------------------------------------
-- Server version	8.0.31

-- Table structure for table `attachfile`
--

DROP TABLE IF EXISTS `attachfile`;
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
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

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

-- Dump completed on 2023-01-26 23:20:34
