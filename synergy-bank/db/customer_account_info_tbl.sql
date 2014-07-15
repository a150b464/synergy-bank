/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : synergy_bank_db
Target Host     : localhost:3306
Target Database : synergy_bank_db
Date: 2014-07-15 14:39:43
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
  `customerEmail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_account_info_tbl
-- ----------------------------
INSERT INTO `customer_account_info_tbl` VALUES ('41', 'naim123', '1000000000', 'AccType', '1000', '1000', 'Currency', 'Md Naim Hossain', '2014-07-15 00:09:05', '2014-07-15 00:09:05', 'findnaim@gmail.com');
INSERT INTO `customer_account_info_tbl` VALUES ('42', 'a12345', '1000000001', 'AccType', '1000', '1000', 'Currency', 'f m l', '2014-07-15 00:10:30', '2014-07-15 00:10:30', 'findnaim@gmail.com');
INSERT INTO `customer_account_info_tbl` VALUES ('43', 'naim123', '1000000002', 'AccType', '1000', '1000', 'Currency', 'Md Naim Hossain', '2014-07-15 00:10:30', '2014-07-15 00:10:30', 'findnaim@gmail.com');
INSERT INTO `customer_account_info_tbl` VALUES ('44', 'a12345', '1000000003', 'AccType', '1000', '1000', 'Currency', 'f m l', '2014-07-15 00:14:43', '2014-07-15 00:14:43', 'findnaim@gmail.com');
INSERT INTO `customer_account_info_tbl` VALUES ('45', 'naim123', '1000000004', 'AccType', '1000', '1000', 'Currency', 'Md Naim Hossain', '2014-07-15 00:14:43', '2014-07-15 00:14:43', 'findnaim@gmail.com');
INSERT INTO `customer_account_info_tbl` VALUES ('46', 'naim123', '1000000005', 'AccType', '1000', '1000', 'Currency', 'Md Naim Hossain', '2014-07-15 14:15:01', '2014-07-15 14:15:01', 'findnaim@gmail.com');

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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_account_numbers_tbl
-- ----------------------------
INSERT INTO `customer_account_numbers_tbl` VALUES ('54', 'naim123', 'Md Naim Hossain', '1000000000');
INSERT INTO `customer_account_numbers_tbl` VALUES ('55', 'a12345', 'f m l', '1000000001');
INSERT INTO `customer_account_numbers_tbl` VALUES ('56', 'naim123', 'Md Naim Hossain', '1000000002');
INSERT INTO `customer_account_numbers_tbl` VALUES ('57', 'a12345', 'f m l', '1000000003');
INSERT INTO `customer_account_numbers_tbl` VALUES ('58', 'naim123', 'Md Naim Hossain', '1000000004');
INSERT INTO `customer_account_numbers_tbl` VALUES ('59', 'naim123', 'Md Naim Hossain', '1000000005');

-- ----------------------------
-- Table structure for customer_details_tbl
-- ----------------------------
DROP TABLE IF EXISTS `customer_details_tbl`;
CREATE TABLE `customer_details_tbl` (
  `userId` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(16) NOT NULL,
  `salutation` varchar(8) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `firstName` varchar(40) DEFAULT NULL,
  `middleName` varchar(40) DEFAULT NULL,
  `lastName` varchar(40) DEFAULT NULL,
  `maritalStatus` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `category` varchar(12) DEFAULT NULL,
  `motherMaidenName` varchar(30) DEFAULT NULL,
  `fatherName` varchar(40) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(13) DEFAULT NULL,
  `ssn` varchar(14) DEFAULT NULL,
  `occupation` varchar(40) DEFAULT NULL,
  `occupationType` varchar(34) DEFAULT NULL,
  `education` varchar(40) DEFAULT NULL,
  `grossAnualIncome` varchar(10) DEFAULT NULL,
  `sourceOfFunds` varchar(20) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  `photo` longblob,
  `doe` date DEFAULT NULL,
  `dom` date DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `approve` varchar(5) NOT NULL DEFAULT 'no',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_details_tbl
-- ----------------------------
INSERT INTO `customer_details_tbl` VALUES ('a12345', '1234567', '', '', 'f', 'm', 'l', '', null, '', '', '', 'findnaim@gmail.com', '', '', '', '', '', '', '', '', '', null, null, '', 'no');
INSERT INTO `customer_details_tbl` VALUES ('naim123', '123', null, null, 'Md', 'Naim', 'Hossain', null, null, null, null, null, 'findnaim@gmail.com', '123-4561234', null, null, null, null, null, null, null, 0xFFD8FFE0, '2014-07-10', '2014-07-10', null, 'yes');

-- ----------------------------
-- Table structure for customer_login_tbl
-- ----------------------------
DROP TABLE IF EXISTS `customer_login_tbl`;
CREATE TABLE `customer_login_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` varchar(3) DEFAULT NULL,
  `approve` varchar(255) NOT NULL DEFAULT 'no',
  `createdDate` datetime DEFAULT NULL,
  `loginCount` bigint(20) NOT NULL,
  `loginId` varchar(255) DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `numberOfAttempt` int(11) NOT NULL,
  `oldPassword` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_login_tbl
-- ----------------------------
INSERT INTO `customer_login_tbl` VALUES ('1', 'yes', 'no', '2014-07-14 13:16:28', '1', 'a12345', '2014-07-14 13:16:43', '1', null, 'admin', 'admin', null);
INSERT INTO `customer_login_tbl` VALUES ('2', 'yes', 'yes', null, '2', 'naim123', null, '2', null, 'naim', 'user', null);
