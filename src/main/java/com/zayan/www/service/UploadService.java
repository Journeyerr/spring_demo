package com.zayan.www.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {

    /**
     * 上传文件
     *
     * @param multipartFile multipartFile
     * @param suffix        文件名后缀
     * @param dirName       文件夹名
     * @return 相对路径
     */
    String fileUploadToLocal(MultipartFile multipartFile, List<String> suffix, String dirName);

    /**
     * 上传文件
     *
     * @param multipartFile multipartFile
     * @param suffix        文件名后缀
     * @param dirName       文件夹名
     * @return 相对路径
     */
    String fileUploadToOss(MultipartFile multipartFile, List<String> suffix, String dirName);
}
