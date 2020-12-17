package org.javatx.log;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/7 9:11
 */
@Entity
@Table(name = "log")
@Data
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 标题
     */
    private String title;
}
