CREATE TABLE `reply` (
  `rNo` int NOT NULL AUTO_INCREMENT,
  `bNo` int NOT NULL,
  `writeDay` varchar(45) DEFAULT NULL,
  `id` varchar(45) NOT NULL,
  `contents` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rNo`),
  KEY `fk_idx` (`bNo`),
  KEY `fk_reply_member_idx` (`id`),
  CONSTRAINT `fk_reply_board` FOREIGN KEY (`bNo`) REFERENCES `board` (`bNo`),
  CONSTRAINT `fk_reply_member` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci