ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'rootroot';

CREATE TABLE IF NOT EXISTS `TBL_USER` (
                            `ID` bigint NOT NULL AUTO_INCREMENT,
                            `USER_ID` varchar(36) NOT NULL,
                            `NAME` varchar(256) NOT NULL,
                            PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;