//package org.javatx.controller;
//
//import org.javatx.pojo.*;
//import org.javatx.service.ArticleService;
//import org.javatx.service.CategoryService;
//import org.javatx.service.TagsService;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * @Author: 胡俊杰
// * @Date: 2020/8/4 17:02
// */
//@Controller
//@RequestMapping("/article")
//public class ArticleController {
//
//    private final ArticleService articleService;
//    private final CategoryService categoryService;
//    private final TagsService tagsService;
//
//    public ArticleController(ArticleService articleService, CategoryService categoryService, TagsService tagsService) {
//        this.articleService = articleService;
//        this.categoryService = categoryService;
//        this.tagsService = tagsService;
//    }
//
//    @RequestMapping("/list")
//    public String list(){
//        return "backstage/article/article-list";
//    }
//    @ResponseBody
//    @RequestMapping("/findAll")
//    public ResponseData<Article> findAll(Article article, Integer page, Integer limit){
//        Page<Article> articlePage = articleService.search(article,page-1,limit);
//        ResponseData<Article> articleResponseData = new ResponseData<>();
//        articleResponseData.setCode("0");
//        articleResponseData.setCount(articlePage.getTotalElements());
//        articleResponseData.setData(articlePage.getContent());
//        articleResponseData.setMas("请求成功");
//        return articleResponseData;
//    }
//
//    @RequestMapping("/detail/{id}")
//    public String detail(@PathVariable("id")Long id, Model model){
//        Article article = articleService.findById(id);
//        model.addAttribute("article",article);
//        List<Tags> tagsList = tagsService.findAll();
//        model.addAttribute(tagsList);
//        return "view/detail";
//        //return "htmls/calmlog-details";
//    }
//
//    @RequestMapping("/detail1/{id}")
//    public String detail1(@PathVariable("id")Long id, Model model){
//        Article article = articleService.findById(id);
//        model.addAttribute("article",article);
//        List<Tags> tagsList = tagsService.findAll();
//        model.addAttribute(tagsList);
//        return "htmls/calmlog-details";
//    }
//    @RequestMapping("/add")
//    public String add(Model model){
//        List<Category> categoryList = categoryService.findAll();
//        model.addAttribute("categoryList",categoryList);
//        return "backstage/article/article-edit";
//    }
//    @RequestMapping("/update/{id}")
//    public String update(@PathVariable("id") Long id, Model model){
//        Article article = articleService.findById(id);
//        List<Category> categoryList = categoryService.findAll();
//        model.addAttribute("article",article);
//        model.addAttribute("categoryList",categoryList);
//        return "backstage/article/article-edit";
//    }
//    @ResponseBody
//    @RequestMapping("/insert")
//    public boolean insert(Article article){
//        articleService.insert(article);
//        return true;
//    }
//    @ResponseBody
//    @RequestMapping("/delete/{id}")
//    public boolean delete(@PathVariable("id") Long id){
//        articleService.delete(id);
//        return true;
//    }
//}
//
