package com.zayan.www.constant;

/**
 * @author AnYuan
 * @date 2021-01-07
 */

public class RedisConstant {

    /**
     * 秒杀sku的库存
     * @param skuNo skuNo
     * @return key
     */
    public static String secKillSkuStockKey(String skuNo) {
        return "seckill:skus:".concat(skuNo);
    }

    /**
     * 秒杀请求标志和状态
     * @param traceId traceId
     * @return Hash key
     */
    public static String secKillTraceIdKey(String traceId) {
        return "seckill:trace:".concat(traceId);
    }
}
