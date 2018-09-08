/*
Navicat MySQL Data Transfer

Source Server         : miaosha
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lxxqdddd

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-31 21:09:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `miaosha_goods`
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_goods`;
CREATE TABLE `miaosha_goods` (
  `id` bigint(20) NOT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `miaosha_price` double(10,2) DEFAULT NULL,
  `stock_count` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of miaosha_goods
-- ----------------------------
INSERT INTO `miaosha_goods` VALUES ('1', '1', '0.01', '0', '2018-07-23 14:42:01', '2018-07-31 14:43:22');
INSERT INTO `miaosha_goods` VALUES ('2', '2', '0.01', '12', '2018-07-23 14:32:28', '2018-07-31 14:32:36');
