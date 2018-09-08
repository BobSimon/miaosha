/*
Navicat MySQL Data Transfer

Source Server         : miaosha
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lxxqdddd

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-31 21:15:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `delivery_addr_id` bigint(20) DEFAULT NULL,
  `goods_name` varchar(16) DEFAULT NULL,
  `goods_count` int(11) DEFAULT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `order_channel` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4206 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('4148', '13000000017', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:50', null);
INSERT INTO `order_info` VALUES ('4149', '13000000026', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:50', null);
INSERT INTO `order_info` VALUES ('4150', '13000000069', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:50', null);
INSERT INTO `order_info` VALUES ('4151', '13000000020', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:50', null);
INSERT INTO `order_info` VALUES ('4152', '13000000032', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:50', null);
INSERT INTO `order_info` VALUES ('4153', '13000000019', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:50', null);
INSERT INTO `order_info` VALUES ('4154', '13000000076', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4155', '13000000018', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4156', '13000000025', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4157', '13000000072', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4158', '13000000066', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4159', '13000000010', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4160', '13000000057', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4161', '13000000063', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4162', '13000000034', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:51', null);
INSERT INTO `order_info` VALUES ('4163', '13000000059', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:52', null);
INSERT INTO `order_info` VALUES ('4164', '13000000022', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:52', null);
INSERT INTO `order_info` VALUES ('4165', '13000000036', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:52', null);
INSERT INTO `order_info` VALUES ('4166', '13000000062', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:52', null);
INSERT INTO `order_info` VALUES ('4167', '13000000056', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:52', null);
INSERT INTO `order_info` VALUES ('4168', '13000000040', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:52', null);
INSERT INTO `order_info` VALUES ('4169', '13000000078', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:52', null);
INSERT INTO `order_info` VALUES ('4170', '13000000000', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:53', null);
INSERT INTO `order_info` VALUES ('4171', '13000000023', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:53', null);
INSERT INTO `order_info` VALUES ('4172', '13000000024', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4173', '13000000079', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4174', '13000000003', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4175', '13000000080', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4176', '13000000011', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4177', '13000000033', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4178', '13000000065', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4179', '13000000049', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4180', '13000000070', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4181', '13000000061', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4182', '13000000012', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:54', null);
INSERT INTO `order_info` VALUES ('4183', '13000000029', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4184', '13000000021', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4185', '13000000002', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4186', '13000000005', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4187', '13000000030', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4188', '13000000031', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4189', '13000000014', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4190', '13000000006', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4191', '13000000009', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4192', '13000000083', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4193', '13000000004', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4194', '13000000082', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:55', null);
INSERT INTO `order_info` VALUES ('4195', '13000000067', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:56', null);
INSERT INTO `order_info` VALUES ('4196', '13000000016', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:56', null);
INSERT INTO `order_info` VALUES ('4197', '13000000028', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:10:56', null);
INSERT INTO `order_info` VALUES ('4198', '13000000099', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:16:21', null);
INSERT INTO `order_info` VALUES ('4199', '13000000100', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:19:30', null);
INSERT INTO `order_info` VALUES ('4200', '13000000101', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:22:56', null);
INSERT INTO `order_info` VALUES ('4201', '13000000102', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-28 23:25:41', null);
INSERT INTO `order_info` VALUES ('4202', '13000000104', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-29 00:17:56', null);
INSERT INTO `order_info` VALUES ('4203', '13000000108', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-29 00:18:10', null);
INSERT INTO `order_info` VALUES ('4204', '13000000109', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-29 00:19:41', null);
INSERT INTO `order_info` VALUES ('4205', '13000000110', '2', null, 'huaweiMeta9', '1', '2356.00', '1', '0', '2018-07-29 00:22:53', null);
