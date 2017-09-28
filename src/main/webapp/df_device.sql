/*
Navicat MySQL Data Transfer

Source Server         : 192.168.123.53
Source Server Version : 50719
Source Host           : 192.168.123.53:3306
Source Database       : dftest

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-28 16:01:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `df_device`
-- ----------------------------
DROP TABLE IF EXISTS `df_device`;
CREATE TABLE `df_device` (
  `device_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `apppath` varchar(100) NOT NULL,
  `device_name` varchar(100) NOT NULL,
  `platform_name` varchar(100) NOT NULL,
  `platform_version` varchar(100) NOT NULL,
  `udid` varchar(100) NOT NULL,
  `noReset` int(1) DEFAULT NULL COMMENT '0/true，1/false',
  `stopOnRest` int(1) DEFAULT NULL COMMENT '0/true，1/false',
  `uri` varchar(100) DEFAULT NULL,
  `unicodeKeyboard` int(1) DEFAULT NULL COMMENT '0/true，1/false',
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of df_device
-- ----------------------------
INSERT INTO `df_device` VALUES ('1', 'a', 'a', 'Android', 'a', 'a', '0', '0', 'a', '0');
