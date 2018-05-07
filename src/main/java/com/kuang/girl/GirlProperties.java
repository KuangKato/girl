package com.kuang.girl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String cupSize;
    private Integer age;
//    private List<Map<String,String>> list;
//
//    public List<Map<String, String>> getList() {
//        return list;
//    }
//
//    public void setList(List<Map<String, String>> list) {
//        this.list = list;
//    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

