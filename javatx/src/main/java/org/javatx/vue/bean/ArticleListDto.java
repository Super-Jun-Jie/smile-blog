package org.javatx.vue.bean;
import lombok.Getter;
import lombok.Setter;
import org.javatx.pojo.ArticleInfo;

import java.util.List;
import java.util.Date;

@Setter@Getter
public class ArticleListDto {

    private Long id;
    private ArticleInfo articleInfo;
    private String desc;
    private String imgUrl;
    private List<String> tags;
    private List<String> category;
    private String title;
    private Date createTime;


}
