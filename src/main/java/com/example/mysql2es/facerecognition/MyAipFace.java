package com.example.mysql2es.facerecognition;

import com.baidu.aip.face.AipFace;
import com.example.mysql2es.ocr.OCRSystemConstants;

/**
 * @Author: admin
 * @Description: 基于百度AI开放平台-人脸识别的Java客户端
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.facerecognition
 * @CreateTime: 2020-12-03 15:19:24
 */
public class MyAipFace {

    public static void main(String[] args) {
        AipFace client = new AipFace("23030947", OCRSystemConstants.API_KEY, OCRSystemConstants.SECRET_KEY);

    }


}
