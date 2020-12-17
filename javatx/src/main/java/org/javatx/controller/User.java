package org.javatx.controller;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/21 14:01
 */
//@JacksonXmlRootElement(localName = "user")
public class User {
    //@JacksonXmlProperty(localName = "username")
    private String username;
    //@JacksonXmlProperty(localName = "age")
    private Integer age;
    //@JacksonXmlProperty(localName = "sex")
    private String sex;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }



    public User(String username, Integer age, String sex) {
        this.username = username;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }
}
