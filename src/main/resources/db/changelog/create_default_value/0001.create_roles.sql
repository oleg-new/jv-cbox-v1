--liquibase formatted sql
--changeset author:olegnew
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_OPERATOR');
