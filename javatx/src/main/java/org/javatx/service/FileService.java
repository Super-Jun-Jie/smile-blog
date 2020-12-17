package org.javatx.service;

import org.javatx.pojo.FileBean;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/5 9:44
 */
public interface FileService {
    FileBean getBySha1(String sha1);

    void save(FileBean fileBean);

    FileBean findById(Long id);

    List<FileBean> findAll();
}
