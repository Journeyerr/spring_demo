package com.zayan.www.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;

public class ImageUtil {

    /**
     * 通过读取文件并获取其width及height的方式，来判断判断当前文件是否图片
     *
     * @param imageFile
     * @return
     */
    public static boolean isImage(MultipartFile imageFile) {
        // 先校验后缀名
        if (!checkImageSuffix(imageFile)) {
            return false;
        }

        if (imageFile.isEmpty()) {
            return false;
        }
        Image img;
        try {
            img = ImageIO.read(imageFile.getInputStream());
            return img != null && img.getWidth(null) > 0 && img.getHeight(null) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据文件名判断文件是否为图片
     */
    public static boolean checkImageSuffix(MultipartFile file) {
        return file != null && checkImageSuffix(file.getOriginalFilename());
    }

    /**
     * 根据文件名判断文件是否为图片
     */
    private static boolean checkImageSuffix(String fileName) {
        String path = fileName.toUpperCase();
        return path.endsWith(".PNG") || path.endsWith(".JPG")
                || path.endsWith(".JPEG") || path.endsWith(".BMP")
                || path.endsWith(".GIF");
    }
}
