CREATE TABLE `admin_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员名称',
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员手机',
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员密码',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `deelted_at` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci comment = "管理员用户表";