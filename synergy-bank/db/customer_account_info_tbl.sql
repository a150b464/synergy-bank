/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : synergy_bank_db
Target Host     : localhost:3306
Target Database : synergy_bank_db
Date: 2014-07-14 13:58:36
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for customer_account_info_tbl
-- ----------------------------
DROP TABLE IF EXISTS `customer_account_info_tbl`;
CREATE TABLE `customer_account_info_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) NOT NULL,
  `customerAccountNo` varchar(30) NOT NULL,
  `accountType` varchar(30) DEFAULT NULL,
  `availBalance` double DEFAULT NULL,
  `totalAvailBalance` double DEFAULT NULL,
  `currency` varchar(20) DEFAULT NULL,
  `customerName` varchar(120) DEFAULT NULL,
  `doe` datetime DEFAULT NULL,
  `dom` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_account_info_tbl
-- ----------------------------
INSERT INTO `customer_account_info_tbl` VALUES ('22', 'naim123', '1000000000', 'AccType', '1000', '1000', 'Currency', 'Md Naim Hossain', '2014-07-14 13:54:14', '2014-07-14 13:54:14');
INSERT INTO `customer_account_info_tbl` VALUES ('23', 'yadna01', '1000000001', 'AccType', '1000', '1000', 'Currency', 'null null null', '2014-07-14 13:54:14', '2014-07-14 13:54:14');

-- ----------------------------
-- Table structure for customer_account_numbers_tbl
-- ----------------------------
DROP TABLE IF EXISTS `customer_account_numbers_tbl`;
CREATE TABLE `customer_account_numbers_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(20) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `accountNumber` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_account_numbers_tbl
-- ----------------------------
INSERT INTO `customer_account_numbers_tbl` VALUES ('31', 'naim123', 'Md Naim Hossain', '1000000000');
INSERT INTO `customer_account_numbers_tbl` VALUES ('32', 'yadna01', 'null null null', '1000000001');
