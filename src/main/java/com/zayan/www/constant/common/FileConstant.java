package com.zayan.www.constant.common;


import java.util.Arrays;
import java.util.List;

/**
 * 文件
 */

public interface FileConstant {


    /**
     * 图片后缀list
     */
    List<String> IMAGE_SUFFIX = Arrays.asList("png", "jpeg", "jpg", "PNG", "JPEG", "JPG");

    /**
     * 商品图片上传文件夹
     */
    String PRODUCT_IMAGE_DIR = "products";
}
