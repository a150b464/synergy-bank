/*
Navicat MySQL Data Transfer

Source Server         : synergisticit
Source Server Version : 50013
Source Host           : localhost:3306
Source Database       : synergy_bank_db

Target Server Type    : MYSQL
Target Server Version : 50013
File Encoding         : 65001

Date: 2014-07-09 11:45:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `customer_details_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_details_tbl`;
CREATE TABLE `customer_details_tbl` (
  `userId` varchar(20) NOT NULL default '',
  `password` varchar(16) NOT NULL,
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
INSERT INTO `customer_details_tbl` VALUES ('yadna01', 'test@123', null, null, null, null, null, null, null, null, null, null, 'nagend@gmail.com', '23243443', null, null, null, null, null, null, null, null, null, null, 'new  Customer');
