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
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `email` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `phone_show` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '加密后的手机号',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `avatar_id` int(10) unsigned NOT NULL COMMENT '头像id',
  `image_url` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信头像url',
  `sex` enum('male','female','unknow') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'unknow' COMMENT '性别',
  `wxlite_session_key` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小程序session',
  `wxlite_open_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小程序openid',
  `wx_union_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信unionid',
  `jpush_id` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '极光推送设备号id',
  `district` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信备注地区',
  `password` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `last_login_at` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记住登陆状态',
  `is_vip` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '测试用户字段',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`),
  KEY `users_name_index` (`name`),
  KEY `users_avatar_id_index` (`avatar_id`),
  KEY `users_sex_index` (`sex`),
  KEY `users_wxlite_open_id_index` (`wxlite_open_id`),
  KEY `users_wx_union_id_index` (`wx_union_id`),
  KEY `users_phone_index` (`phone`),
  KEY `users_phone_show_index` (`phone_show`),
  KEY `users_created_at_index` (`created_at`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'javatest', NULL, '15011112222', 'f8e3c6c21204b747', '1995-02-01', 0, 'https://wx.qlogo.cn/mmopen/vi_32/6urYs11boWYhibaJIVgjv922CVpiaq75bjKcWicEK7rPWKNLw2Q8wgFIZwsxjYXicEK2j7WO1Yu4BTk4h6Ysc8nozQ/0', 'female', 'bZDAkTYGshWL1GOUZ64X4w==', 'onsAE0W60UG96BYYAbMey4wXEtHw', NULL, NULL, NULL, '', '2018-05-18 16:04:42', NULL, 0, '2018-02-07 16:03:35', '2018-12-05 10:27:22', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
