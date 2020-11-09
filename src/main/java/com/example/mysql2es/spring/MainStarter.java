package com.example.mysql2es.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: admin
 * @Description: 注解方式启动spring容器测试类
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.spring
 * @CreateTime: 2020-11-09 23:02
 */
public class MainStarter {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person)context.getBean("person");
        System.out.println("person:"+person);
    }


}
