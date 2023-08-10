
--liquibase formatted sql
--changeset author:olegnew
INSERT INTO `users` (id, locked, name, password) VALUES (1,_binary '\0','Admin','$2a$10$H6EYsuZcMno7GTTObDBJG.yF0q8HwMKa1HUvTx7Zm9jQ/igCOddWS');
INSERT INTO `users_roles` (user_id, role_id) VALUES (1,1),(1,2),(1,3);