CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL COMMENT '门店id',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '商品名称',
  `price` decimal(8,2) DEFAULT NULL COMMENT '商品价格',
  `quantity` int(11) DEFAULT '1' COMMENT '商品数量',
  `unit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品单元',
  `remark` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `image_id` int(11) DEFAULT NULL COMMENT '图片id',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用  1 是， 0 停用',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;