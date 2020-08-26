package com.zayan.www.controller.admin;

import com.zayan.www.constant.common.FileConstant;
import com.zayan.www.model.entity.Image;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.ImageService;
import com.zayan.www.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("admin/upload")
public class AdminUploadController {

    @Autowired
    private UploadService uploadService;
    @Autowired
    private ImageService imageService;

    @PostMapping("/image")
    public BaseResult<Image> upload(@RequestParam("file") MultipartFile multipartFile) {
        String imagePath = uploadService.fileUploadToOss(multipartFile, FileConstant.IMAGE_SUFFIX, FileConstant.PRODUCT_IMAGE_DIR);

        Image image = new Image();
        image.setPath(imagePath);
        imageService.save(image);

        return BaseResult.success(image);
    }
}
