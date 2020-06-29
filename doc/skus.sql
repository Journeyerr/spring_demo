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

 Date: 28/06/2020 16:20:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for skus
-- ----------------------------
DROP TABLE IF EXISTS `skus`;
CREATE TABLE `skus` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `no` int(11) DEFAULT NULL COMMENT 'skuNo',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `version` int(11) DEFAULT NULL COMMENT '版本控制 防止并发',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
