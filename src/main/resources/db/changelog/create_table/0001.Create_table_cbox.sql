--liquibase formatted sql

--changeset author:olegnew
CREATE TABLE `cbox` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `house` varchar(255) DEFAULT NULL,
                        `ip_address` varchar(255) DEFAULT NULL,
                        `snmp_community` varchar(255) DEFAULT NULL,
                        `street` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ;
