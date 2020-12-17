package org.javatx.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: 胡俊杰
 * @Date: 2020/11/23 14:06
 */
@Getter@Setter
public class ArticleInfo {
    //查看次数
    private Integer viewCount;
    //评论次数
    private Integer commentCount;
    //喜欢次数
    private Integer likeCount;

    public ArticleInfo(){

    }

    public ArticleInfo(Integer viewCount, Integer commentCount, Integer likeCount) {
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
    }
}
