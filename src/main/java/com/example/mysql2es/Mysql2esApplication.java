package com.example.mysql2es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;

@SpringBootApplication
public class Mysql2esApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Mysql2esApplication.class, args);
        AnnotationMBeanExporter exporter = context.getBean(AnnotationMBeanExporter.class);
        System.out.println("exporter bean:" + exporter);
        context.close();
    }

}
