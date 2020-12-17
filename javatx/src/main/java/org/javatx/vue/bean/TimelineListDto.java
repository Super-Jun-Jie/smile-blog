package org.javatx.vue.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/8 16:18
 */
@Setter@Getter
public class TimelineListDto {
    private String year;
    private List<ArticleTimelineDto> articles;

    public TimelineListDto(String year, List<ArticleTimelineDto> articles) {
        this.year = year;
        this.articles = articles;
    }
}
