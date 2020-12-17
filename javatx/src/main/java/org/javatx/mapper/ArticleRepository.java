package org.javatx.mapper;

import org.javatx.pojo.Article;
import org.javatx.vue.bean.TimelineDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/4 17:25
 */
public interface ArticleRepository extends JpaRepository<Article,Long> , JpaSpecificationExecutor<Article> {

}
