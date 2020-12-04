package com.example.mysql2es.facerecognition;

import com.baidu.aip.contentcensor.EImgType;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.example.mysql2es.ocr.OCRSystemConstants;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: admin
 * @Description: 人脸识别控制器
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.ai
 * @CreateTime: 2020-12-03 14:19:55
 */
@RestController
public class FaceRecognitionController {

    public static final Logger logger = LoggerFactory.getLogger(FaceRecognitionController.class);

    @PostMapping(value = "/face/recognition")
    public String handle(@RequestParam("code")String code) {
        String base64 = code.replace("data:image/png;base64,","");
        AipFace client = new AipFace(FaceSystemConstants.APP_ID, FaceSystemConstants.API_KEY,
                FaceSystemConstants.SECRET_KEY);
        // 人脸识别
        /*
        JSONObject result = client.detect(base64, "BASE64", null);*/

        // 人脸比对
        /*MatchRequest r1 = new MatchRequest(base64, "BASE64");
        String pic = Base64Utils.getBase64FromLocalSystem("F:\\我的档案\\档案\\登记照\\IMG_82.7k_base64.txt");
        MatchRequest r2 = new MatchRequest(pic, "BASE64");
        List<MatchRequest> list = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        JSONObject result = client.match(list);
        logger.info("人脸比对结果:\n"+result.toString(2));*/

        // 人脸检测
        HashMap<String, String> options = new HashMap<>();
        options.put("face_field", "age");
        /*options.put("face_field", "beauty");
        options.put("face_field", "expression");
        options.put("face_field", "face_shape");
        options.put("face_field", "gender");
        options.put("face_field", "glasses");
        options.put("face_field", "eye_status");
        options.put("face_field", "emotion");
        options.put("face_field", "race");
        options.put("face_field", "face_type");
        options.put("face_field", "quality");*/
        options.put("face_type", "LIVE");

        JSONObject result = client.detect(base64, "BASE64", options);
        logger.info("result:\n"+result.toString(2));
        return result.toString(2);
    }


}
