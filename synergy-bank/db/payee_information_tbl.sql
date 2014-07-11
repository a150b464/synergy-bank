/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : synergy_bank_db
Target Host     : localhost:3306
Target Database : synergy_bank_db
Date: 2014-07-10 23:38:32
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for payee_information_tbl
-- ----------------------------
DROP TABLE IF EXISTS `payee_information_tbl`;
CREATE TABLE `payee_information_tbl` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) NOT NULL,
  `payeeAccountNo` varchar(30) DEFAULT NULL,
  `payeeName` varchar(120) DEFAULT NULL,
  `payeeNickName` varchar(40) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `doe` datetime DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of payee_information_tbl
-- ----------------------------
INSERT INTO `payee_information_tbl` VALUES ('1', '1', '1234', 'Tridib', 'Banerjee', '123-3455043', '2014-07-09 21:42:30');
INSERT INTO `payee_information_tbl` VALUES ('2', '1', '2345', 'Jeff', 'Chen', '111-2223333', '2014-07-08 21:42:45');
INSERT INTO `payee_information_tbl` VALUES ('3', '1', '564', 'Swapnil', 'swapnil', '987-5431345', '2014-07-07 22:30:19');
