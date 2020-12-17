package org.javatx.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 10:58
 * 标签
 */
@Setter@Getter
public class Tags{
    /**
     * 自增id
     */
    private Long id;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 文章id
     */
    private Long articleId;
}
