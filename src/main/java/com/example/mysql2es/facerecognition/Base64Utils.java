package com.example.mysql2es.facerecognition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: admin
 * @Description: 获取图片的base64编码工具类
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.facerecognition
 * @CreateTime: 2020-12-03 17:15:07
 */
public class Base64Utils {

    /**
     * 从文件中获取图片对应的base64编码，防止程序报字符串常量异常
     * @param path
     * @return
     */
    public static String getBase64FromLocalSystem(String path){
        File file = new File(path);
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                builder.append(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(SpringVersion.getVersion());
        System.out.println(SpringBootVersion.getVersion());
    }

}
