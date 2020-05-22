CREATE DATABASE  IF NOT EXISTS `tinder`;
USE `tinder`;


DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `user_to` int(250) DEFAULT NULL,
  `user_from` int(250) DEFAULT NULL,
  `message` text,
  `localId` int(250) DEFAULT NULL,
  `dateTime` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `message` WRITE;


UNLOCK TABLES;

