package org.javatx.service.impl;

import org.javatx.mapper.ArticleBatis;
import org.javatx.mapper.ArticleRepository;
import org.javatx.mapper.TagsMapper;
import org.javatx.pojo.Article;
import org.javatx.pojo.Category;
import org.javatx.pojo.FileBean;
import org.javatx.service.ArticleService;
import org.javatx.service.CategoryService;
import org.javatx.service.FileService;
import org.javatx.vue.bean.TimelineDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/4 17:04
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final FileService fileService;
    private final CategoryService categoryService;
    private final TagsMapper tagsMapper;
    private final ArticleBatis articleBatis;

    public ArticleServiceImpl(ArticleRepository articleRepository, FileService fileService, CategoryService categoryService, TagsMapper tagsMapper, ArticleBatis articleBatis) {
        this.articleRepository = articleRepository;
        this.fileService = fileService;
        this.categoryService = categoryService;
        this.tagsMapper = tagsMapper;
        this.articleBatis = articleBatis;
    }
    @Override
    public Page<Article> search(Article article, int page, Integer limit) {
        Sort sort = Sort.by(Sort.Direction.DESC, "modifier");
        PageRequest pageRequest = PageRequest.of(page,limit,sort);
        return articleRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(article.getMdContent())){
                list.add(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("title").as(String.class),"%"+article.getMdContent()+"%")
                        ,criteriaBuilder.like(root.get("mdContent").as(String.class),"%"+article.getMdContent()+"%")
                        ,criteriaBuilder.like(root.get("htmlContent").as(String.class),"%"+article.getMdContent()+"%")
                ));
            }
            return criteriaBuilder.and(list.toArray(list.toArray(new Predicate[0])));
        },pageRequest);
    }

    @Override
    public void insert(Article article) {
        Category category = categoryService.findById(article.getCid());
        article.setCategory(category);
        if (!StringUtils.isEmpty(article.getImgId())){
            FileBean fileBean = fileService.findById(article.getImgId());
            article.setImgUrl(fileBean.getPath());
        }
        //保存标签
        Set<String> tags = article.getTags();
        articleRepository.saveAndFlush(article);
        tagsMapper.saveTags(tags,article.getId());
    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article findById(Long id) {
        Optional<Article> optional = articleRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Article> findAll(final String keyWord) {

        return articleRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(keyWord)){
                String search = "%"+keyWord+"%";
                list.add(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("title").as(String.class),search)
                        ,criteriaBuilder.like(root.get("content").as(String.class),search)
                        ,criteriaBuilder.like(root.get("category").get("cateName").as(String.class),search)
                ));

            }
            return criteriaBuilder.and(list.toArray(new Predicate[0]));
        });
    }

    @Override
    public Page<Article> vueSearch(String search, int pageNum, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "modifier");
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, sort);
        return articleRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(search)) {
                list.add(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("title").as(String.class), "%" + search + "%")
                        , criteriaBuilder.like(root.get("mdContent").as(String.class), "%" + search + "%")
                        , criteriaBuilder.like(root.get("htmlContent").as(String.class), "%" + search + "%")
                ));
            }
            return criteriaBuilder.and(list.toArray(list.toArray(new Predicate[0])));
        }, pageRequest);
    }

    @Override
    public List<TimelineDto> getTimeline() {
        return articleBatis.getTimeline();
    }
}
