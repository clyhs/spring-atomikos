/*
MySQL Data Transfer
Source Host: localhost
Source Database: spring_atomikos1
Target Host: localhost
Target Database: spring_atomikos1
Date: 2016/6/4 17:02:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for demo
-- ----------------------------
CREATE TABLE `demo` (
  `id` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` decimal(10,0) DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `demo` VALUES ('0000', 'aaaa', '1234', 'ABCD');
INSERT INTO `demo` VALUES ('33333', 'aaaa', '1234', 'ABCD');
INSERT INTO `demo` VALUES ('5555', 'aaaa', '1234', 'ABCD');
