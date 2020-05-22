CREATE DATABASE  IF NOT EXISTS `tinder`;
USE `tinder`;

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `user_likes` int(250) DEFAULT NULL,
  `user_liked` int(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `likes` WRITE;

UNLOCK TABLES;

