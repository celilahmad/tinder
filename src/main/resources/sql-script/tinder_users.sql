CREATE DATABASE  IF NOT EXISTS `tinder` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `tinder`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(250) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `imgurl` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES (1,'timur@tinder.com','123','Timur','Python','https://robohash.org/24.218.243.24.png'),
(2,'jalil@tinder.com','123','Jalil','Java','https://robohash.org/24.218.243.23.png'),
(3,'alik@tinder.com','123','Alik','C#','https://robohash.org/24.218.243.25.png'),
(4,'jim@tinder.com','123','Jim','Js','https://robohash.org/24.218.243.26.png'),
(5,'jeremy@tinder.com','123','Jeremy','C++','https://robohash.org/24.218.243.27.png'),
(6,'john@tinder.com','123','John','Kotlin','https://robohash.org/24.218.243.28.png');

UNLOCK TABLES;

