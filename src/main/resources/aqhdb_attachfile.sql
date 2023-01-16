DROP TABLE IF EXISTS `attachfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attachfile` (
  `fNo` int NOT NULL AUTO_INCREMENT,
  `bNo` int NOT NULL,
  `uuid` varchar(80) DEFAULT NULL,
  `originName` varchar(100) DEFAULT NULL,
  `uploadPath` varchar(400) DEFAULT NULL,
  `fileSize` int DEFAULT NULL,
  `fmtFileSize` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`fNo`),
  KEY `fk_attachfile_board_idx` (`bNo`),
  CONSTRAINT `fk_attachfile_board` FOREIGN KEY (`bNo`) REFERENCES `board` (`bNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb3;