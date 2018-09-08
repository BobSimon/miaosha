/*
Navicat MySQL Data Transfer

Source Server         : miaosha
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lxxqdddd

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-31 21:04:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL,
  `goods_name` varchar(16) DEFAULT NULL,
  `goods_title` varchar(64) DEFAULT NULL,
  `goods_img` varchar(64) DEFAULT NULL,
  `goods_detail` longtext,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `goods_stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'iphoneX', 'alalalal', '/img/iphone8.png', 'dwdwd', '8598.00', '10');
INSERT INTO `goods` VALUES ('2', 'huaweiMeta9', 'alibaba', '/img/meta10.png', 'dadada', '2356.00', '20');
