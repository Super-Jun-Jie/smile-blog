package org.javatx.vue.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class Data<T> {
    private int count;
    private List<T> list;
}
