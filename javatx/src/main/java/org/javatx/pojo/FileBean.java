package org.javatx.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/5 9:47
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "file")
@Data
public class FileBean extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** 文件名 */
    private String name;

    /** 文件路径 */
    private String path;

    /** 文件类型 */
    private String mime;

    /** 文件大小 */
    private Long size;

    /** 文件md5值 */
    private String md5;

    /** 文件sha1值 */
    private String sha1;
}
