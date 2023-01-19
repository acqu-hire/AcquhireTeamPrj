DROP TABLE IF EXISTS `board`; 기존 테이블 삭제 쿼리 주의
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `bNo` int NOT NULL AUTO_INCREMENT,
  `id` varchar(45) NOT NULL,
  `menu` enum('QNA','COMMUNITY','EVENT','NOTICE') DEFAULT NULL,
  `category` enum('QNA_TECH','QNA_CAREER','QNA_ETC','COMMUNITY_LIFE','COMMUNITY_GROUP','EVENT_IT_EVENT','EVENT_MARKETING','NOTICE_NOTICE','NOTICE_EVENT') DEFAULT NULL,
  `readCount` int DEFAULT '0',
  `replyCnt` int DEFAULT '0',
  `files` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `contents` varchar(3000) DEFAULT NULL,
  `writeDay` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bNo`),
  KEY `fk_board_member_idx` (`id`),
  CONSTRAINT `fk_board_member` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;
