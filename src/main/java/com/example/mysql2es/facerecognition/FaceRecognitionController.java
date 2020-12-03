package com.example.mysql2es.facerecognition;

import com.baidu.aip.contentcensor.EImgType;
import com.baidu.aip.face.AipFace;
import com.example.mysql2es.ocr.OCRSystemConstants;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: admin
 * @Description: 人脸识别控制器
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.ai
 * @CreateTime: 2020-12-03 14:19:55
 */
@RestController
public class FaceRecognitionController {

    @PostMapping(value = "/face/recognition")
    public String handle(@RequestParam("code")String code) {
        String base64 = code.replace("data:image/png;base64,","");
        AipFace client = new AipFace(FaceSystemConstants.APP_ID, FaceSystemConstants.API_KEY,
                FaceSystemConstants.SECRET_KEY);
        JSONObject result = client.detect(base64, "BASE64", null);
        return result.toString(2);
    }


}
