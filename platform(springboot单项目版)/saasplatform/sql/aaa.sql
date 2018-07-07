/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : aaa

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-07-02 14:35:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='资源权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '*', '系统管理员', '');
INSERT INTO `permission` VALUES ('2', 'user:*', '用户管理员', '');
INSERT INTO `permission` VALUES ('3', 'user:get', '查看用户', '');
INSERT INTO `permission` VALUES ('4', 'user:create', '创建用户', '');
INSERT INTO `permission` VALUES ('5', 'user:edit', '编辑用户', '');
INSERT INTO `permission` VALUES ('6', 'user:roleEdit', '更改角色', '');
INSERT INTO `permission` VALUES ('7', 'user:member', '查看子帐号', '');
INSERT INTO `permission` VALUES ('8', 'user:resetPass', '重置他人密码', '');
INSERT INTO `permission` VALUES ('9', 'role:*', '角色管理员', '');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `grade` int(11) NOT NULL DEFAULT '0' COMMENT '角色级别,不可以创建比自己权限高的角色',
  `uid` int(10) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '9', '1', '呵呵呵呵呵呵呵', '2017-08-12 15:27:56', '2017-09-16 10:27:23', '1');
INSERT INTO `role` VALUES ('2', '管理员', '9', '1', '呵呵呵呵呵呵呵', '2017-08-12 15:27:56', '2017-09-16 10:27:23', '1');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `permissionId` int(11) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`),
  KEY `rid_unqiue_idx` (`roleId`),
  KEY `pid_my_foreign_idx` (`permissionId`),
  CONSTRAINT `resource` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`pid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `role` FOREIGN KEY (`roleId`) REFERENCES `role` (`rid`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '1', '2');
INSERT INTO `role_permission` VALUES ('3', '1', '3');
INSERT INTO `role_permission` VALUES ('4', '1', '4');
INSERT INTO `role_permission` VALUES ('5', '1', '5');
INSERT INTO `role_permission` VALUES ('6', '1', '6');
INSERT INTO `role_permission` VALUES ('7', '1', '7');
INSERT INTO `role_permission` VALUES ('8', '1', '8');
INSERT INTO `role_permission` VALUES ('9', '1', '9');
INSERT INTO `role_permission` VALUES ('12', '2', '2');
INSERT INTO `role_permission` VALUES ('13', '2', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(5) NOT NULL DEFAULT '0',
  `username` varchar(20) NOT NULL,
  `password` varchar(35) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'admin', '123456');
INSERT INTO `user` VALUES ('2', '2', 'test', '123456');
