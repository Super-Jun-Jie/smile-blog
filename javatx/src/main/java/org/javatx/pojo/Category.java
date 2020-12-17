package org.javatx.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 10:54
 * 分类
 */
@Entity
@Table(name = "category")
public class Category  extends BaseEntity{
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 分类名称
     */
    private String cateName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
