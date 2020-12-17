package org.javatx.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Set;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/7 16:35
 */
public interface TagsMapper {
    @Update("<script> " +
            "insert into tags (article_id,tag_name) values " +
            "<foreach collection='list' item='item' separator = ','> " +
            "(#{id},#{item})" +
            "</foreach>" +
            "</script>")
    void saveTags(Set<String> list, Long id);



    @Select("<script> " +
            "select tag_name from tags where 1 = 1 " +
            "<if test='articleId != null'>" +
            " article_id = #{id} " +
            "</if>" +
            "</script>")
    List<String> getTagsByArticleId(Long articleId);
}
