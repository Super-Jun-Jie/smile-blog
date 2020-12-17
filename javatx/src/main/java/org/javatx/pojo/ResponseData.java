package org.javatx.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ResponseData<T>{
    String code;
    String mas;
    Long count;
    List<T> data;
}