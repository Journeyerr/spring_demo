package com.zayan.www.service.impl;

import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.UploadException;
import com.zayan.www.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Override
    public String fileUpload(MultipartFile multipartFile)  {

        String originalFileName = multipartFile.getOriginalFilename();
        if (multipartFile.isEmpty() || Objects.isNull(originalFileName)) {
            log.info("fileUpload_error, 文件为空");
            throw new UploadException(ErrorEnum.FILE_ERROR);
        }

        String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        List<String> allowSuffix = Arrays.asList("png", "jpeg", "jpg");

        if (!allowSuffix.contains(suffix)) {
            log.info("文件后缀名错误：{}", originalFileName);
            throw new UploadException(ErrorEnum.FILE_ERROR);
        }

        String filePath = "src/main/resources/images/";
        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String fileName = UUID.randomUUID().toString().replace("-", "") +
                "." + suffix;

        File fileDir = new File(filePath + format);
        if (!fileDir.isDirectory()) {
            boolean mkdir = fileDir.mkdirs();
            if (!mkdir) {
                throw new UploadException(ErrorEnum.FILE_UPLOAD_DIR_ERROR);
            }
        }

        try {
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + fileName);
            multipartFile.transferTo(newFile);
            log.info("文件上传成功：{}, currentName:{}", fileName, filePath + format);
            return format + "/" + fileName;
        } catch (IOException e) {
            log.info("文件上传失败：{}: error:{}", fileName, e.getMessage());
        }
        return null;
    }
}
