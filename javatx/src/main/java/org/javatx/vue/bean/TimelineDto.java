package org.javatx.vue.bean;

import lombok.Getter;
import lombok.Setter;
import org.javatx.pojo.Article;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/7 16:40
 */
@Setter@Getter
public class TimelineDto {
    String year;
    Long articleId;
    String title;
    List<ArticleData> list;
}
@Setter@Getter
class ArticleData{
    Long articleId;
    String title;
}
