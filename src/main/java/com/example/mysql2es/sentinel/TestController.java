package com.example.mysql2es.sentinel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: admin
 * @Description: sentinel整合spring cloud
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.sentinel
 * @CreateTime: 2020-12-01 15:07:40
 */
@RestController
public class TestController {

    @Autowired
    private TestService service;

    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name){
        return service.sayHello(name);
    }

}
