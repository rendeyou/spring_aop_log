/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-06-02 02:23:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` char(32) NOT NULL COMMENT '密码',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `regist_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zhangsan', '123456', '2019-10-16', '2019-10-16 21:31:23');
INSERT INTO `tb_user` VALUES ('2', 'lisi', '123456', '2019-09-30', '2019-09-30 00:59:47');
INSERT INTO `tb_user` VALUES ('3', 'wangwu', '123456', '2019-09-30', '2019-09-30 00:59:47');
INSERT INTO `tb_user` VALUES ('4', 'zhaoliu', '123456', '2019-09-30', '2019-09-30 00:59:47');
INSERT INTO `tb_user` VALUES ('5', '久久', '202cb962ac59075b964b07152d234b70', '2019-10-01', '2019-10-01 12:08:56');
INSERT INTO `tb_user` VALUES ('6', 'maba', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('7', 'chenjiu', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('8', 'xiaoshi', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('9', 'shiyi', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('10', 'shier', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('11', 'shisan', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('12', 'shisi', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('13', 'shiwu', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('14', 'shiliu', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('15', 'shiqi', '123456', '2019-10-01', '2019-10-01 12:53:45');
INSERT INTO `tb_user` VALUES ('29', 'zhouxingchi', 'e10adc3949ba59abbe56e057f20f883e', '2019-10-11', '2019-10-11 23:27:18');
INSERT INTO `tb_user` VALUES ('30', 'zhouxingxing', 'e10adc3949ba59abbe56e057f20f883e', '2019-10-11', '2019-10-11 23:27:18');
INSERT INTO `tb_user` VALUES ('56', '张三', '123', '2019-11-15', '2019-11-15 17:54:39');
INSERT INTO `tb_user` VALUES ('66', 'xiaoming', '202cb962ac59075b964b07152d234b70', '1992-03-12', '2020-02-19 11:14:32');
INSERT INTO `tb_user` VALUES ('67', 'xiaohong', '202cb962ac59075b964b07152d234b70', '1995-07-19', '2020-02-19 11:14:32');
INSERT INTO `tb_user` VALUES ('68', 'xiaogang', '202cb962ac59075b964b07152d234b70', '1992-02-15', '2020-02-19 11:14:32');
INSERT INTO `tb_user` VALUES ('69', 'xiaohua', '202cb962ac59075b964b07152d234b70', '1999-09-12', '2020-02-19 11:14:32');
INSERT INTO `tb_user` VALUES ('70', 'xiaobai', '202cb962ac59075b964b07152d234b70', '1992-04-17', '2020-02-19 11:14:32');
INSERT INTO `tb_user` VALUES ('71', 'xiaoqiang', '202cb962ac59075b964b07152d234b70', '1992-03-18', '2020-02-19 11:14:32');
INSERT INTO `tb_user` VALUES ('72', '刘刘', '202cb962ac59075b964b07152d234b70', '2020-05-31', '2020-05-31 17:45:50');
INSERT INTO `tb_user` VALUES ('73', 'xiaoxiao', '202cb962ac59075b964b07152d234b70', '1992-03-12', '2020-05-31 19:39:33');
INSERT INTO `tb_user` VALUES ('74', 'xiaozhong', '202cb962ac59075b964b07152d234b70', '1995-07-19', '2020-05-31 19:39:33');
INSERT INTO `tb_user` VALUES ('75', 'xiaoda', '202cb962ac59075b964b07152d234b70', '1992-02-15', '2020-05-31 19:39:33');
INSERT INTO `tb_user` VALUES ('76', 'xiaoju', '202cb962ac59075b964b07152d234b70', '1999-09-12', '2020-05-31 19:39:33');
INSERT INTO `tb_user` VALUES ('77', 'xiaowei', '202cb962ac59075b964b07152d234b70', '1992-04-17', '2020-05-31 19:39:33');
INSERT INTO `tb_user` VALUES ('78', 'dada', '202cb962ac59075b964b07152d234b70', '1992-03-18', '2020-05-31 19:39:33');
