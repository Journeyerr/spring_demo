CREATE TABLE `product_image_show` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` decimal(8,2) DEFAULT NULL COMMENT '价格',
  `remark` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述备注',
  `image_id` int(11) DEFAULT NULL COMMENT '图片id',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted_at` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;