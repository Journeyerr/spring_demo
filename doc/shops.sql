/*
 Navicat Premium Data Transfer

 Source Server         : docker-root
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 127.0.0.1:3306
 Source Schema         : spring_boot

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 28/06/2020 16:20:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shops
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店名称',
  `no` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店编码',
  `is_enable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '门店启停1为启用',
  `country` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家名称',
  `province` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '省级名称',
  `contact_phone` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `city` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '城市名称',
  `city_code` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '城市code',
  `district` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '区域名称',
  `district_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区号',
  `address` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店地址',
  `longitude` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '纬度',
  `latitude` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '经度',
  `open_at` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '开店时间',
  `close_at` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '关店时间',
  `delivery_distance` int(10) unsigned  DEFAULT null COMMENT '外卖配送距离',
  `delivery_fee` decimal(8,2) DEFAULT null COMMENT '外卖配送费',
  `takeaway_status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '外卖状态 0关1开',
  `tips` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '门店提示语',
  `qr_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '门店二维码',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shops_no_unique` (`no`),
  KEY `shops_name_index` (`name`),
  KEY `shops_contact_phone_index` (`contact_phone`),
  KEY `shops_city_code_index` (`city_code`),
  KEY `shops_open_at_index` (`open_at`),
  KEY `shops_close_at_index` (`close_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of shops
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
