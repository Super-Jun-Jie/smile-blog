package org.javatx.service;

import javafx.animation.Timeline;
import org.javatx.pojo.Article;
import org.javatx.vue.bean.TimelineDto;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/4 17:04
 */
public interface ArticleService {
    Page<Article> search(Article article, int page, Integer limit);

    void insert(Article article);

    void delete(Long id);

    Article findById(Long id);

    List<Article> findAll(String keyWord);

    Page<Article> vueSearch(String query, int i, Integer pageSize);

    List<TimelineDto> getTimeline();
}
