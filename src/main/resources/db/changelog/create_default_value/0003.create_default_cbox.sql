--liquibase formatted sql
--changeset author:olegnew
INSERT INTO `cbox` (id, house, ip_address, snmp_community, street) VALUES (1,'0','192.168.0.10','public','Default');

