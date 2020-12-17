package org.javatx.controller;

import org.javatx.pojo.Article;
import org.javatx.pojo.Category;
import org.javatx.pojo.Tags;
import org.javatx.service.ArticleService;
import org.javatx.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/13 15:56
 */
@Controller("/view")
public class ViewController {
    private final ArticleService articleService;
    private final CategoryService categoryService;

    public ViewController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }
//    //主页
//    @RequestMapping("/")
//    public String index(String mdContent , Article article, Model model) {
//        article.setMdContent(mdContent);
//        List<Category> categoryList = categoryService.findAll();
//        List<Tags> tagsList = tagsService.findAll();
//        List<Article> articleList = articleService.search(article, 0, 10).getContent();
//        model.addAttribute(articleList);
//        model.addAttribute(categoryList);
//        model.addAttribute(tagsList);
//        model.addAttribute("mdContent", article.getMdContent());
//        //return "htmls/calmlog-index";
//        return "view/index";
//    }
    //关于我
    @RequestMapping("/view/about")
    public String about(String mdContent , Article article, Model model) {
        article.setMdContent(mdContent);
        List<Category> categoryList = categoryService.findAll();
        List<Article> articleList = articleService.search(article, 0, 10).getContent();
        model.addAttribute(articleList);
        model.addAttribute(categoryList);
        model.addAttribute("mdContent", article.getMdContent());
        //return "htmls/calmlog-index";
        return "view/about";
    }
    //留言
}
