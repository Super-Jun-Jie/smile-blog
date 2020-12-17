package org.javatx.mapper;

import org.apache.ibatis.annotations.Select;
import org.javatx.vue.bean.TimelineDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/7 17:53
 */
public interface ArticleBatis {
    //
    @Select("select date_format(create_date,'%Y') as year,title,id as 'articleId' from article order by create_date desc")
    List<TimelineDto> getTimeline();
}
