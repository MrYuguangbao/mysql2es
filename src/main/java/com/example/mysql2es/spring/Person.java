package com.example.mysql2es.spring;

import java.util.Locale;

/**
 * @Author: admin
 * @Description: 实体类
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.spring
 * @CreateTime: 2020-11-09 22:58
 */
public class Person {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
