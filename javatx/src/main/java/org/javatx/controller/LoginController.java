package org.javatx.controller;

import org.javatx.service.ArticleService;
import org.javatx.service.CarouselService;
import org.javatx.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 9:40
 */
@Controller
@RequestMapping("/")
public class LoginController {
    private final CategoryService categoryService;
    private final CarouselService carouselService;
    private final ArticleService articleService;

    public LoginController(CategoryService categoryService, CarouselService carouselService, ArticleService articleService) {
        this.categoryService = categoryService;
        this.carouselService = carouselService;
        this.articleService = articleService;
    }


    @RequestMapping("/login")
    @ResponseBody
    public boolean login(String username,String password){
        System.out.println(username+"---"+password);
        return true;
    }
    @RequestMapping("/houtai")
    public String backstage(){
        return "backstage/main/index";
    }

//    @RequestMapping("/index")
//        public String index(String mdContent ,Article article,Model model){
//        article.setMdContent(mdContent);
//        List<Category> categoryList = categoryService.findAll();
//        List<Tags> tagsList = tagsService.findAll();
//        List<Carousel> carouselList = carouselService.findAll();
//        List<Article> articleList = articleService.search(article,0,10).getContent();
//        model.addAttribute(articleList);
//        model.addAttribute(categoryList);
//        model.addAttribute(tagsList);
//        model.addAttribute(carouselList);
//        model.addAttribute("mdContent",article.getMdContent());
//        //return "htmls/calmlog-index";
//        return "view/index";
//    }
}

