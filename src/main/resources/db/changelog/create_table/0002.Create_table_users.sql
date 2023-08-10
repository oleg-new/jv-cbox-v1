--liquibase formatted sql

--changeset author:olegnew
CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `locked` bit(1) NOT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
