package org.javatx.service.impl;

import org.javatx.mapper.CategoryRepository;
import org.javatx.pojo.Article;
import org.javatx.pojo.Category;
import org.javatx.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 11:05
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        return optional.orElse(new Category());
    }

    @Override
    public void insert(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> search(Category category, int page, Integer limit) {
        Sort sort = Sort.by(Sort.Direction.DESC, "modifyDate");
        PageRequest pageRequest = PageRequest.of(page, limit, sort);
        return categoryRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            return criteriaBuilder.and(list.toArray(list.toArray(new Predicate[0])));
        }, pageRequest);
    }

    @Override
    public Page<Category> getCategoryList(int page, Integer limit) {
        return categoryRepository.findAll(PageRequest.of(page,limit));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
