-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aqhdb
-- ------------------------------------------------------
-- Server version	8.0.31

-- Table structure for table `attachfile`
--

DROP TABLE IF EXISTS `attachfile`;
CREATE TABLE `attachfile` (
    `fno` INT NOT NULL AUTO_INCREMENT,
    `bno` INT NOT NULL,
    `uuid` VARCHAR(80) DEFAULT NULL,
    `originName` VARCHAR(100) DEFAULT NULL,
    `uploadPath` VARCHAR(400) DEFAULT NULL,
    `fileSize` INT DEFAULT NULL,
    `fmtFileSize` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`fno`),
    KEY `fk_attachfile_board_idx` (`bno`),
    CONSTRAINT `fk_attachfile_board` FOREIGN KEY (`bno`)
        REFERENCES `board` (`bno`)
        ON DELETE CASCADE
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
    `bno` INT NOT NULL AUTO_INCREMENT,
    `id` VARCHAR(45) NOT NULL,
    `menu` ENUM('QNA', 'COMMUNITY', 'EVENT', 'NOTICE') DEFAULT NULL,
    `category` ENUM('QNA_TECH', 'QNA_CAREER', 'QNA_ETC', 'COMMUNITY_LIFE', 'COMMUNITY_GROUP', 'EVENT_IT_EVENT', 'EVENT_MARKETING', 'NOTICE_NOTICE', 'NOTICE_EVENT') DEFAULT NULL,
    `readCount` INT DEFAULT '0',
    `replyCnt` INT DEFAULT '0',
    `files` VARCHAR(100) DEFAULT NULL,
    `title` VARCHAR(100) DEFAULT NULL,
    `contents` VARCHAR(3000) DEFAULT NULL,
    `writeDay` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`bno`),
    KEY `fk_board_member_idx` (`id`),
    CONSTRAINT `fk_board_member` FOREIGN KEY (`id`)
        REFERENCES `member` (`id`)
        ON DELETE CASCADE
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
    `id` VARCHAR(45) NOT NULL,
    `password` VARCHAR(32) DEFAULT NULL,
    `name` VARCHAR(32) DEFAULT NULL,
    `gender` VARCHAR(45) DEFAULT NULL,
    `address` VARCHAR(200) DEFAULT NULL,
    `phone_number` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(100) DEFAULT NULL,
    `reg_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
    `rno` INT NOT NULL AUTO_INCREMENT,
    `bno` INT NOT NULL,
    `prno` INT DEFAULT NULL,
    `writeDay` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `id` VARCHAR(45) NOT NULL,
    `contents` VARCHAR(3000) DEFAULT NULL,
    PRIMARY KEY (`rno`),
    KEY `fk_idx` (`bno`),
    KEY `fk_reply_member_idx` (`id`),
    CONSTRAINT `fk_reply_board` FOREIGN KEY (`bno`)
        REFERENCES `board` (`bno`)
        ON DELETE CASCADE,
    CONSTRAINT `fk_reply_member` FOREIGN KEY (`id`)
        REFERENCES `member` (`id`)
        ON DELETE CASCADE
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;

-- Dump completed on 2023-01-26 23:20:34
