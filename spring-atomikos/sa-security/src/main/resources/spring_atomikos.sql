/*
MySQL Data Transfer
Source Host: localhost
Source Database: spring_atomikos
Target Host: localhost
Target Database: spring_atomikos
Date: 2016/6/5 16:19:46
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
-- Table structure for t_resource
-- ----------------------------
CREATE TABLE `t_resource` (
  `rescId` int(11) DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pId` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `reskey` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `resurl` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
CREATE TABLE `t_role` (
  `roleId` int(11) DEFAULT NULL,
  `rolename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rolecode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_role_resource
-- ----------------------------
CREATE TABLE `t_role_resource` (
  `roleId` int(11) DEFAULT NULL,
  `rescId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE `t_user` (
  `userId` int(11) DEFAULT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
CREATE TABLE `t_user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `demo` VALUES ('0000', 'aaaa', '1234', 'ABCD');
INSERT INTO `demo` VALUES ('0000', 'aaaa', '1234', 'ABCD');
INSERT INTO `demo` VALUES ('0000', 'aaaa', '1234', 'ABCD');
INSERT INTO `t_resource` VALUES ('1', '系统管理', '0', '1', '0', 'sa_system', 'system');
INSERT INTO `t_resource` VALUES ('2', '用户管理', '1', '2', '1', 'sa_user', '/module/security/user/index.html');
INSERT INTO `t_resource` VALUES ('3', '角色管理', '1', '2', '1', 'sa_role', '/module/security/role/index.html');
INSERT INTO `t_resource` VALUES ('4', '资源管理', '1', '2', '1', 'sa_resource', '/module/security/resource/index.html');
INSERT INTO `t_resource` VALUES ('5', '查询用户', '2', '3', '2', 'sa_user_query', '/module/security/user/query**');
INSERT INTO `t_resource` VALUES ('6', '添加用户', '2', '3', '2', 'sa_user_add', '/module/security/user/add.html');
INSERT INTO `t_resource` VALUES ('7', '删除用户', '2', '3', '2', 'sa_user_delete', '/module/security/user/delete**');
INSERT INTO `t_resource` VALUES ('8', '查询角色', '3', '3', '2', 'sa_role_query', '/module/security/role/query**');
INSERT INTO `t_resource` VALUES ('9', '添加角色', '3', '3', '2', 'sa_role_add', '/module/security/role/add**');
INSERT INTO `t_resource` VALUES ('10', '任务管理', '0', '1', '0', 'sa_quartz', 'quartz');
INSERT INTO `t_role` VALUES ('1', '管理员', 'ROLE_ADMIN');
INSERT INTO `t_role_resource` VALUES ('1', '1');
INSERT INTO `t_role_resource` VALUES ('1', '2');
INSERT INTO `t_role_resource` VALUES ('1', '3');
INSERT INTO `t_role_resource` VALUES ('1', '4');
INSERT INTO `t_role_resource` VALUES ('1', '6');
INSERT INTO `t_user` VALUES ('1', 'admin', '123456');
INSERT INTO `t_user_role` VALUES ('1', '1');
