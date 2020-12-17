package org.javatx.service.impl;

import org.javatx.mapper.FileMapper;
import org.javatx.pojo.FileBean;
import org.javatx.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/5 9:44
 */
@Service
public class FileServiceImpl implements FileService {
    private final FileMapper fileMapper;

    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public FileBean getBySha1(String sha1) {
        return fileMapper.findBySha1(sha1);
    }

    @Override
    public void save(FileBean fileBean) {
        fileMapper.save(fileBean);
    }

    @Override
    public FileBean findById(Long id) {
        Optional<FileBean> optional = fileMapper.findById(id);
        return optional.orElse(new FileBean());
    }

    @Override
    public List<FileBean> findAll() {
        return fileMapper.findAll();
    }
}
