package org.javatx.mapper;

import org.javatx.pojo.FileBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/5 10:39
 */
public interface FileMapper extends JpaRepository<FileBean,Long>, JpaSpecificationExecutor<FileBean> {
    FileBean findBySha1(String sha1);
}
