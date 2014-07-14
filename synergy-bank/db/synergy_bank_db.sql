/*
Navicat MySQL Data Transfer

Source Server         : synergisticit
Source Server Version : 50013
Source Host           : localhost:3306
Source Database       : synergy_bank_db

Target Server Type    : MYSQL
Target Server Version : 50013
File Encoding         : 65001

Date: 2014-07-14 15:39:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `customer_account_info_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_account_info_tbl`;
CREATE TABLE `customer_account_info_tbl` (
  `id` int(11) NOT NULL auto_increment,
  `userid` varchar(20) NOT NULL,
  `customerAccountNo` varchar(30) NOT NULL,
  `accountType` varchar(30) default NULL,
  `availBalance` double default NULL,
  `totalAvailBalance` double default NULL,
  `currency` varchar(20) default NULL,
  `customerName` varchar(120) default NULL,
  `doe` datetime default NULL,
  `dom` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_account_info_tbl
-- ----------------------------
INSERT INTO `customer_account_info_tbl` VALUES ('22', 'naim123', '1000000000', 'AccType', '1000', '1000', 'Currency', 'Md Naim Hossain', '2014-07-14 13:54:14', '2014-07-14 13:54:14');
INSERT INTO `customer_account_info_tbl` VALUES ('23', 'yadna01', '1000000001', 'AccType', '1000', '1000', 'Currency', 'null null null', '2014-07-14 13:54:14', '2014-07-14 13:54:14');

-- ----------------------------
-- Table structure for `customer_account_numbers_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_account_numbers_tbl`;
CREATE TABLE `customer_account_numbers_tbl` (
  `id` int(11) NOT NULL auto_increment,
  `userId` varchar(20) NOT NULL,
  `name` varchar(120) default NULL,
  `accountNumber` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_account_numbers_tbl
-- ----------------------------
INSERT INTO `customer_account_numbers_tbl` VALUES ('31', 'naim123', 'Md Naim Hossain', '1000000000');
INSERT INTO `customer_account_numbers_tbl` VALUES ('32', 'yadna01', 'null null null', '1000000001');

-- ----------------------------
-- Table structure for `customer_details_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_details_tbl`;
CREATE TABLE `customer_details_tbl` (
  `userId` varchar(20) NOT NULL default '',
  `password` varchar(16) default NULL,
  `salutation` varchar(8) default NULL,
  `gender` varchar(6) default NULL,
  `firstName` varchar(40) default NULL,
  `middleName` varchar(40) default NULL,
  `lastName` varchar(40) default NULL,
  `maritalStatus` varchar(10) default NULL,
  `dob` date default NULL,
  `category` varchar(12) default NULL,
  `motherMaidenName` varchar(30) default NULL,
  `fatherName` varchar(40) default NULL,
  `email` varchar(100) default NULL,
  `mobile` varchar(13) default NULL,
  `ssn` varchar(14) default NULL,
  `occupation` varchar(40) default NULL,
  `occupationType` varchar(34) default NULL,
  `education` varchar(40) default NULL,
  `grossAnualIncome` varchar(10) default NULL,
  `sourceOfFunds` varchar(20) default NULL,
  `role` varchar(10) default NULL,
  `photo` longblob,
  `doe` date default NULL,
  `dom` date default NULL,
  `description` varchar(30) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_details_tbl
-- ----------------------------
INSERT INTO `customer_details_tbl` VALUES ('8733yye', null, null, null, null, null, null, null, null, null, null, null, 'dd@gmail.com', '34342', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `customer_details_tbl` VALUES ('fsf', 'sf', 'sfs', 'sd', 'sf', 'sf', 's', 'sf', null, 'sdf', 'sdf', 'sd', 's', 'sf', 'sdf', 's', '', '', '', '', '', '', null, null, 'new  Customer');
INSERT INTO `customer_details_tbl` VALUES ('yadna01', 'test@123', null, null, null, null, null, null, null, null, null, null, 'nagend@gmail.com', '23243443', null, null, null, null, null, null, null, null, null, null, 'new  Customer');

-- ----------------------------
-- Table structure for `customer_login_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_login_tbl`;
CREATE TABLE `customer_login_tbl` (
  `id` bigint(20) NOT NULL auto_increment,
  `active` varchar(3) default NULL,
  `approve` varchar(255) default NULL,
  `createdDate` datetime default NULL,
  `loginCount` bigint(20) NOT NULL,
  `loginId` varchar(255) default NULL,
  `modifiedDate` datetime default NULL,
  `numberOfAttempt` int(11) NOT NULL,
  `oldPassword` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `role` varchar(20) default NULL,
  `status` varchar(8) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_login_tbl
-- ----------------------------
INSERT INTO `customer_login_tbl` VALUES ('1', 'yes', 'no', '1969-12-31 00:00:00', '1', 'admin', '1969-12-31 00:00:00', '0', '', 'admin', 'sadmin', 'super');
INSERT INTO `customer_login_tbl` VALUES ('2', 'yes', 'yes', '2012-02-23 01:35:52', '0', 'as2331212', '2012-02-23 01:35:52', '0', null, 'asth421212', 'customer', 'unlocked');
INSERT INTO `customer_login_tbl` VALUES ('3', 'yes', 'yes', '2012-02-23 02:45:05', '0', 'sa1221212', '2012-02-23 02:45:05', '0', null, 'sant781212', 'customer', 'unlocked');
INSERT INTO `customer_login_tbl` VALUES ('4', 'yes', 'yes', '2012-02-24 01:50:13', '0', 'sa1220101', '2012-02-24 01:50:13', '0', null, 'saro270101', 'customer', 'unlocked');
INSERT INTO `customer_login_tbl` VALUES ('5', 'yes', 'no', '2012-02-26 08:59:49', '0', 'aj8881212', '2012-02-26 08:59:49', '0', null, 'ajay971212', 'customer', 'unlocked');

-- ----------------------------
-- Table structure for `customer_transactions_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_transactions_tbl`;
CREATE TABLE `customer_transactions_tbl` (
  `id` bigint(20) NOT NULL auto_increment,
  `accountID` varchar(255) default NULL,
  `ammount` int(11) NOT NULL,
  `creditDr` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  `transactionDate` datetime default NULL,
  `transactionId` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_transactions_tbl
-- ----------------------------

-- ----------------------------
-- Table structure for `payee_information_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `payee_information_tbl`;
CREATE TABLE `payee_information_tbl` (
  `sno` int(11) NOT NULL auto_increment,
  `userid` varchar(20) NOT NULL,
  `payeeAccountNo` varchar(30) default NULL,
  `payeeName` varchar(120) default NULL,
  `payeeNickName` varchar(40) default NULL,
  `mobile` varchar(30) default NULL,
  `doe` datetime default NULL,
  `email` varchar(100) default NULL,
  `status` varchar(20) default NULL,
  PRIMARY KEY  (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of payee_information_tbl
-- ----------------------------
INSERT INTO `payee_information_tbl` VALUES ('1', '1', '1234', 'Tridib', 'Banerjee', '123-3455043', '2014-07-09 21:42:30', null, null);
INSERT INTO `payee_information_tbl` VALUES ('2', '1', '2345', 'Jeff', 'Chen', '111-2223333', '2014-07-08 21:42:45', null, null);
INSERT INTO `payee_information_tbl` VALUES ('3', '1', '564', 'Swapnil', 'swapnil', '987-5431345', '2014-07-07 22:30:19', null, null);
INSERT INTO `payee_information_tbl` VALUES ('4', '34535345', 'nagendra', 'nagen', 'nagendra.yadav.j2ee@gmail.com', '20202020', '0000-00-00 00:00:00', '2014-07-14 15:14:49.0', 'pending');

-- ----------------------------
-- Table structure for `transaction_id_generator_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `transaction_id_generator_tbl`;
CREATE TABLE `transaction_id_generator_tbl` (
  `id` bigint(20) NOT NULL auto_increment,
  `transactionId` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of transaction_id_generator_tbl
-- ----------------------------
INSERT INTO `transaction_id_generator_tbl` VALUES ('1', '547475');
