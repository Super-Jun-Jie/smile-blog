package org.javatx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Peter
 */
@Data
@NoArgsConstructor
@MappedSuperclass//通过这个注解，可以讲该实体类当成基类实体，它不会隐射到数据库表，但继承它的字类实体在隐射时会自动扫描该基类实体的隐射属性，添加到字类实体类的对应数据库表中
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    @CreatedBy
    private String creator;

    /**
     * 创建日期
     */
    @CreatedDate  // timezone=Constant.CURRENT_TIME_ZONE
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone= "GMT+8")
    private Date createDate;

    /**
     * 更新者
     */
    @LastModifiedBy
    private String modifier;

    /**
     * 更新日期
     */
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone= "GMT+8")
    private Date modifyDate;

    /**
     * 置空属性
     */
    public void clearCommonValue() {
        this.creator = null;
        this.createDate = null;
        this.modifier = null;
        this.modifyDate = null;
    }
}
