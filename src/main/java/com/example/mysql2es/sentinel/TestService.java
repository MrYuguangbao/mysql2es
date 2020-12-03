package com.example.mysql2es.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author: admin
 * @Description: sentinel整合spring boot/spring cloud
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.sentinel
 * @CreateTime: 2020-12-01 15:06:14
 */
@Service
public class TestService {

    @SentinelResource(value = "sayHello")
    public String sayHello(String name){
        return "hello," + name;
    }


}
