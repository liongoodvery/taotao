package com.taotao.controller;

import com.taotao.controller.response.FileUploadResponse;
import com.taotao.controller.utils.FastDFSClient;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureController {
    @Value("${TAOTAO_IMAGE_SERVER_URL}")
    private String taoTaoImageServerUrl;
    private Logger logger = LoggerFactory.getLogger(PictureController.class);


    @RequestMapping("/pic/upload")
    public FileUploadResponse fileUpload(MultipartFile uploadFile) {

        String filename = uploadFile.getOriginalFilename();
        FileUploadResponse response = new FileUploadResponse();
        try {
            byte[] bytes = uploadFile.getBytes();
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:fastdfs_client.conf");
            String url = fastDFSClient.uploadFile(bytes, FilenameUtils.getExtension(filename));
            logger.warn(url);
            response.setError(0);
            response.setUrl(taoTaoImageServerUrl + url);

        } catch (Exception e) {
            e.printStackTrace();
            response.setError(1);
            response.setMessage(e.getMessage());
        }


        return response;

    }
}
