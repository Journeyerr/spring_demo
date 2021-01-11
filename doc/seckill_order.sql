CREATE TABLE `seckill_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `no` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单no',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `sku_no` int(11) DEFAULT NULL COMMENT 'skuNo',
  `status` enum('WAIT_PAY', 'PAID')  DEFAULT 'WAIT_PAY' COMMENT '状态',
  `trace_id` varchar(32) DEFAULT NULL COMMENT '唯一标识',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

