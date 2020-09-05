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

 Date: 28/06/2020 16:20:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `phone` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `image_url` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信头像url',
  `sex` enum('male','female','unknow') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'unknow' COMMENT '性别',
  `wx_session_key` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小程序session',
  `wx_open_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小程序openid',
  `wx_union_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信unionid',
  `country` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信获取的国家名称',
  `province` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信获取的省级名称',
  `city` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信获取的城市名称',
  `district` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信备注地区',
  `last_login_at` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `users_name_index` (`name`),
  KEY `users_sex_index` (`sex`),
  KEY `users_wxlite_open_id_index` (`wx_open_id`),
  KEY `users_wx_union_id_index` (`wx_union_id`),
  KEY `users_phone_index` (`phone`),
  KEY `users_created_at_index` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';
-- ----------------------------
-- Records of users
-- ----------------------------