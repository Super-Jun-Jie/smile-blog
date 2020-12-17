package org.javatx.service;

import org.javatx.pojo.Category;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 11:04
 */
public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    void insert(Category category);

    void deleteById(Long id);

    Page<Category> search(Category category, int page, Integer limit);

    Page<Category> getCategoryList(int page, Integer limit);

    void delete(Long id);
}
