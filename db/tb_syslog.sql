/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-06-02 02:24:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_syslog`
-- ----------------------------
DROP TABLE IF EXISTS `tb_syslog`;
CREATE TABLE `tb_syslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `method` varchar(100) DEFAULT NULL,
  `visitTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `executionTime` bigint(11) DEFAULT NULL,
  `errorMessage` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_syslog
-- ----------------------------
INSERT INTO `tb_syslog` VALUES ('47', '久久', '127.0.0.1', 'http://localhost:8081/spring_aop_log/userList', '[类名]com.bj.controller.UserController[方法名]userList', '2020-02-22 14:55:32', '8140', '/ by zero');
INSERT INTO `tb_syslog` VALUES ('48', '久久', '127.0.0.1', 'http://localhost:8081/spring_aop_log/userList', '[类名]com.bj.controller.UserController[方法名]userList', '2020-02-22 14:56:15', '6673', '/ by zero');
