CREATE TABLE IF NOT EXISTS `USER`
(
    `FIRSTNAME` varchar(255),
    `LASTNAME` varchar(255),
    `ADDRESS_ID` bigint,
    `ID` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS `ADDRESS`
(
    `CITY` varchar(255) NOT NULL ,
    `STREET` varchar(255) NOT NULL ,
    `STREETNR` varchar(255) NOT NULL ,
    `CITYCODE` varchar(255) NOT NULL ,
    `ID` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS `ORGANISATION`
(
    `NAME` varchar(255),
    `ADDRESS_ID` bigint,
    `ID` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
);

ALTER TABLE `USER`
    ADD CONSTRAINT `FK_USER_ADDRESS`
    FOREIGN KEY (`ADDRESS_ID`) 
    REFERENCES `ADDRESS` (`ID`);

CREATE TABLE `USER_ORGANISATION` (
    `USER_ID` BIGINT NOT NULL,
    `ORGANISATION_ID` BIGINT NOT NULL,
    PRIMARY KEY (`USER_ID`, `ORGANISATION_ID`)
);

ALTER TABLE `USER_ORGANISATION`
    ADD CONSTRAINT `FK_USER_ORGANISATION`
    FOREIGN KEY (`USER_ID`) 
    REFERENCES `USER` (`ID`);

ALTER TABLE `USER_ORGANISATION`
    ADD CONSTRAINT `FK_ORGANISATION_ORGANISATION`
    FOREIGN KEY (`ORGANISATION_ID`) 
    REFERENCES `ORGANISATION` (`ID`);

ALTER TABLE `ORGANISATION`
    ADD CONSTRAINT `FK_ORGANISATION_ADDRESS`
    FOREIGN KEY (`ADDRESS_ID`) 
    REFERENCES `ADDRESS` (`ID`);
