package org.javatx.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 11:32
 * 轮播图
 */
@Entity
@Table(name = "Carousel")
public class Carousel  extends BaseEntity{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Long getImgSize() {
        return imgSize;
    }

    public void setImgSize(Long imgSize) {
        this.imgSize = imgSize;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 图片id
     */
    private Long imgId;
    /**
     * 图片大小
     */
    private Long imgSize;
    /**
     * 图片地址
     */
    private String imgUrl;
}
