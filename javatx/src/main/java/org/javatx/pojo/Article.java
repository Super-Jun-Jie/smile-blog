package org.javatx.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 11:50
 */
@Getter@Setter
@Entity
@Table(name = "article")
public class Article extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * md内容
     */
    private String mdContent;
    /**
     * html内容
     */
    private String htmlContent;
    /**
     * 图片id
     */
    private Long imgId;
    /**
     * 配图
     */
    private String imgUrl;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 页面预览
     */
    private Integer pageView;
    @Transient
    private Long cid;
    /**
     * 类别
     */
    @OneToOne
    private Category category;
    /**
     * 标签
     */
    @Transient
    private Set<String> tags;
}
