/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : synergy_bank_db
Target Host     : localhost:3306
Target Database : synergy_bank_db
Date: 2014-07-21 23:36:22
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for userid_gen_tbl
-- ----------------------------
DROP TABLE IF EXISTS `userid_gen_tbl`;
CREATE TABLE `userid_gen_tbl` (
  `sno` int(11) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`sno`,`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userid_gen_tbl
-- ----------------------------
INSERT INTO `userid_gen_tbl` VALUES ('1', '51234582');
