package org.javatx.vue.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/7 18:15
 */
@Setter@Getter
public class ArticleTimelineDto {
    String title;
    Long articleId;

    public ArticleTimelineDto(String title, Long articleId) {
        this.title = title;
        this.articleId = articleId;
    }
}
