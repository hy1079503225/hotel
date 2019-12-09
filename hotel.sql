/*
Navicat MySQL Data Transfer

Source Server         : hongyan
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-12-09 10:23:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for check_in
-- ----------------------------
DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL DEFAULT '1',
  `hotel_id` int(11) NOT NULL DEFAULT '1',
  `room_number` varchar(8) NOT NULL DEFAULT '' COMMENT '房间号',
  `room_type` varchar(16) NOT NULL DEFAULT '' COMMENT '房间类型',
  `person_count` int(11) NOT NULL DEFAULT '1' COMMENT '入住人数',
  `persons` varchar(255) NOT NULL DEFAULT '' COMMENT '入住人',
  `card_ids` varchar(255) NOT NULL DEFAULT '' COMMENT '身份证号',
  `check_in_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_in
-- ----------------------------

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL DEFAULT '1',
  `city` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL DEFAULT '1',
  `user_id` int(11) NOT NULL DEFAULT '1',
  `room_id` int(11) NOT NULL DEFAULT '1',
  `content` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(64) NOT NULL DEFAULT '',
  `phone` varchar(16) NOT NULL DEFAULT '',
  `email` varchar(16) NOT NULL DEFAULT '',
  `address` varchar(64) NOT NULL DEFAULT '',
  `website` varchar(16) NOT NULL DEFAULT '',
  ` create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titile` varchar(64) NOT NULL DEFAULT '',
  `ncontent` varchar(255) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL DEFAULT '1',
  `order_type` varchar(8) NOT NULL DEFAULT '',
  `phone` varchar(16) NOT NULL DEFAULT '',
  `room_type` varchar(16) NOT NULL DEFAULT '',
  `romm_number` int(11) NOT NULL DEFAULT '1',
  `order_date` date NOT NULL COMMENT '预订日期',
  `order_days` int(11) NOT NULL DEFAULT '1' COMMENT '预订天数',
  `order_status` int(11) NOT NULL DEFAULT '0' COMMENT '0表示已下单，1表示已付款，2表示已消费，-1表示已取消，-2表示被删除',
  `order_cost` double NOT NULL DEFAULT '0' COMMENT '订单费用',
  `create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_type
-- ----------------------------
DROP TABLE IF EXISTS `order_type`;
CREATE TABLE `order_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(16) NOT NULL DEFAULT '',
  `remark` varchar(64) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_type
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_number` varchar(8) NOT NULL DEFAULT '',
  `type_id` int(11) NOT NULL DEFAULT '1',
  `room_type` varchar(16) NOT NULL DEFAULT '' COMMENT '房间号码',
  `room_price` double NOT NULL DEFAULT '0',
  `room_discount` double NOT NULL DEFAULT '0',
  `room_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示可预订，1表示已被预定，2代表不可用',
  `remark` varchar(128) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_type` varchar(16) NOT NULL DEFAULT '',
  `remark` varchar(128) NOT NULL DEFAULT '',
  `price` double(11,2) NOT NULL DEFAULT '0.00',
  `discount` double(11,2) NOT NULL DEFAULT '0.00',
  `area` int(11) NOT NULL DEFAULT '12',
  `bed_number` int(11) NOT NULL DEFAULT '1',
  `bed_size` varchar(16) NOT NULL DEFAULT '1.5m*1.8m',
  `window` int(11) NOT NULL DEFAULT '0' COMMENT '//是否有窗：0代表无，1代表有',
  `create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL DEFAULT '',
  `password` varchar(16) NOT NULL DEFAULT '',
  `name` varchar(16) NOT NULL DEFAULT '',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '//1代表男，2代表女',
  `phone` varchar(16) NOT NULL DEFAULT '',
  `email` varchar(16) NOT NULL DEFAULT '',
  `address` varchar(64) NOT NULL DEFAULT '',
  `card_id` varchar(18) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(8) NOT NULL DEFAULT '' COMMENT 'admin',
  `username` varchar(16) NOT NULL DEFAULT '',
  `password` varchar(16) NOT NULL DEFAULT '',
  `name` varchar(8) NOT NULL DEFAULT '',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1代表男性，2代表女性',
  `phone` varchar(16) NOT NULL DEFAULT '',
  `email` varchar(16) NOT NULL DEFAULT '',
  `address` varchar(64) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
