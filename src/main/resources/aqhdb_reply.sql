DROP TABLE IF EXISTS `reply`; 기존 테이블 삭제 쿼리 주의
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `rNo` int NOT NULL AUTO_INCREMENT,
  `bNo` int NOT NULL,
  `writeDay` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `contents` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`rNo`),
  KEY `fk_idx` (`bNo`),
  KEY `fk_reply_member_idx` (`id`),
  CONSTRAINT `fk_reply_board` FOREIGN KEY (`bNo`) REFERENCES `board` (`bNo`) ON DELETE CASCADE,
  CONSTRAINT `fk_reply_member` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;