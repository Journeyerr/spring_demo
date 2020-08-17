package com.zayan.www.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    /**
     * 上传文件
     * @param multipartFile multipartFile
     * @return 相对路径
     */
    String fileUpload(MultipartFile multipartFile);
}
