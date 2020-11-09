package com.example.mysql2es.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: admin
 * @Description: 主配置类
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.spring
 * @CreateTime: 2020-11-09 22:56
 */
@Configuration
@ComponentScan(basePackages = {"com.example.mysql2es.spring"})
public class MainConfig {

    @Bean
    public Person getPerson(){
        Person person = new Person();
        person.setId(1);
        person.setName("spring");
        return person;
    }

}
