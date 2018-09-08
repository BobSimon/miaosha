/*
Navicat MySQL Data Transfer

Source Server         : miaosha
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lxxqdddd

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-31 21:15:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `miaosha_order`
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_order`;
CREATE TABLE `miaosha_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_uid_gid` (`user_id`,`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4206 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of miaosha_order
-- ----------------------------
INSERT INTO `miaosha_order` VALUES ('4148', '13000000017', '4148', '2');
INSERT INTO `miaosha_order` VALUES ('4149', '13000000026', '4149', '2');
INSERT INTO `miaosha_order` VALUES ('4150', '13000000069', '4150', '2');
INSERT INTO `miaosha_order` VALUES ('4151', '13000000020', '4151', '2');
INSERT INTO `miaosha_order` VALUES ('4152', '13000000032', '4152', '2');
INSERT INTO `miaosha_order` VALUES ('4153', '13000000019', '4153', '2');
INSERT INTO `miaosha_order` VALUES ('4154', '13000000076', '4154', '2');
INSERT INTO `miaosha_order` VALUES ('4155', '13000000018', '4155', '2');
INSERT INTO `miaosha_order` VALUES ('4156', '13000000025', '4156', '2');
INSERT INTO `miaosha_order` VALUES ('4157', '13000000072', '4157', '2');
INSERT INTO `miaosha_order` VALUES ('4158', '13000000066', '4158', '2');
INSERT INTO `miaosha_order` VALUES ('4159', '13000000010', '4159', '2');
INSERT INTO `miaosha_order` VALUES ('4160', '13000000057', '4160', '2');
INSERT INTO `miaosha_order` VALUES ('4161', '13000000063', '4161', '2');
INSERT INTO `miaosha_order` VALUES ('4162', '13000000034', '4162', '2');
INSERT INTO `miaosha_order` VALUES ('4163', '13000000059', '4163', '2');
INSERT INTO `miaosha_order` VALUES ('4164', '13000000022', '4164', '2');
INSERT INTO `miaosha_order` VALUES ('4165', '13000000036', '4165', '2');
INSERT INTO `miaosha_order` VALUES ('4166', '13000000062', '4166', '2');
INSERT INTO `miaosha_order` VALUES ('4167', '13000000056', '4167', '2');
INSERT INTO `miaosha_order` VALUES ('4168', '13000000040', '4168', '2');
INSERT INTO `miaosha_order` VALUES ('4169', '13000000078', '4169', '2');
INSERT INTO `miaosha_order` VALUES ('4170', '13000000000', '4170', '2');
INSERT INTO `miaosha_order` VALUES ('4171', '13000000023', '4171', '2');
INSERT INTO `miaosha_order` VALUES ('4172', '13000000024', '4172', '2');
INSERT INTO `miaosha_order` VALUES ('4173', '13000000079', '4173', '2');
INSERT INTO `miaosha_order` VALUES ('4174', '13000000003', '4174', '2');
INSERT INTO `miaosha_order` VALUES ('4175', '13000000080', '4175', '2');
INSERT INTO `miaosha_order` VALUES ('4176', '13000000011', '4176', '2');
INSERT INTO `miaosha_order` VALUES ('4177', '13000000033', '4177', '2');
INSERT INTO `miaosha_order` VALUES ('4178', '13000000065', '4178', '2');
INSERT INTO `miaosha_order` VALUES ('4179', '13000000049', '4179', '2');
INSERT INTO `miaosha_order` VALUES ('4180', '13000000070', '4180', '2');
INSERT INTO `miaosha_order` VALUES ('4181', '13000000061', '4181', '2');
INSERT INTO `miaosha_order` VALUES ('4182', '13000000012', '4182', '2');
INSERT INTO `miaosha_order` VALUES ('4183', '13000000029', '4183', '2');
INSERT INTO `miaosha_order` VALUES ('4184', '13000000021', '4184', '2');
INSERT INTO `miaosha_order` VALUES ('4185', '13000000002', '4185', '2');
INSERT INTO `miaosha_order` VALUES ('4186', '13000000005', '4186', '2');
INSERT INTO `miaosha_order` VALUES ('4187', '13000000030', '4187', '2');
INSERT INTO `miaosha_order` VALUES ('4188', '13000000031', '4188', '2');
INSERT INTO `miaosha_order` VALUES ('4189', '13000000014', '4189', '2');
INSERT INTO `miaosha_order` VALUES ('4190', '13000000006', '4190', '2');
INSERT INTO `miaosha_order` VALUES ('4191', '13000000009', '4191', '2');
INSERT INTO `miaosha_order` VALUES ('4192', '13000000083', '4192', '2');
INSERT INTO `miaosha_order` VALUES ('4193', '13000000004', '4193', '2');
INSERT INTO `miaosha_order` VALUES ('4194', '13000000082', '4194', '2');
INSERT INTO `miaosha_order` VALUES ('4195', '13000000067', '4195', '2');
INSERT INTO `miaosha_order` VALUES ('4196', '13000000016', '4196', '2');
INSERT INTO `miaosha_order` VALUES ('4197', '13000000028', '4197', '2');
INSERT INTO `miaosha_order` VALUES ('4198', '13000000099', '4198', '2');
INSERT INTO `miaosha_order` VALUES ('4199', '13000000100', '4199', '2');
INSERT INTO `miaosha_order` VALUES ('4200', '13000000101', '4200', '2');
INSERT INTO `miaosha_order` VALUES ('4201', '13000000102', '4201', '2');
INSERT INTO `miaosha_order` VALUES ('4202', '13000000104', '4202', '2');
INSERT INTO `miaosha_order` VALUES ('4203', '13000000108', '4203', '2');
INSERT INTO `miaosha_order` VALUES ('4204', '13000000109', '4204', '2');
INSERT INTO `miaosha_order` VALUES ('4205', '13000000110', '4205', '2');
