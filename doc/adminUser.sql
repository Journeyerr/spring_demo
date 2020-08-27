CREATE TABLE `admin_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员名称',
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员手机',
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员密码',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci comment = "管理员用户表";