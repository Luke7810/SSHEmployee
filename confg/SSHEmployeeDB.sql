/*
Navicat MySQL Data Transfer

Source Server         : mylocal
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : userregister

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-02-23 14:45:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '行政部');
INSERT INTO `department` VALUES ('2', '软件部');
INSERT INTO `department` VALUES ('3', '市场部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `depId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '刘强', 'liudl@cn.ibm.com', '2009-06-16', '2017-02-23 14:40:20', '1');
INSERT INTO `employee` VALUES ('2', '张集', 'zhangji@cn.ibm.com', '2010-04-14', '2017-02-23 14:41:00', '1');
INSERT INTO `employee` VALUES ('3', '李想', 'lixiang@cn.ibm.com', '2011-07-28', '2017-02-23 14:41:26', '2');
INSERT INTO `employee` VALUES ('4', '周霞', 'zhouxia@cn.ibm.com', '2010-11-24', '2017-02-23 14:41:57', '3');
INSERT INTO `employee` VALUES ('5', '11111', '1111@asa', '1978-10-02', null, '1');
