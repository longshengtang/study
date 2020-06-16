CREATE TABLE `system_log` (
`id` int NOT NULL AUTO_INCREMENT,
`menu_id` int DEFAULT NULL,
`operation_id` int DEFAULT NULL,
`content` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4;