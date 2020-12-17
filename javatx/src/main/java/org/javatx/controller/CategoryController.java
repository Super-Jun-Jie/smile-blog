//package org.javatx.controller;
//
//import org.javatx.pojo.Category;
//import org.javatx.pojo.ResponseData;
//import org.javatx.service.CategoryService;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * @Author: 胡俊杰
// * @Date: 2020/8/9 10:15
// */
//@Controller
//@RequestMapping("/category")
//public class CategoryController {
//    private final CategoryService categoryService;
//
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @RequestMapping("/list")
//    public String list(){
//        return "backstage/category/category-list";
//    }
//    @ResponseBody
//    @RequestMapping("/findAll")
//    public ResponseData<Category> findAll(Category category, Integer page, Integer limit){
//        Page<Category> categories = categoryService.search(category,page-1,limit);
//        ResponseData<Category> categoryResponseData = new ResponseData<>();
//        categoryResponseData.setCode("0");
//        categoryResponseData.setCount(categories.getTotalElements());
//        categoryResponseData.setData(categories.getContent());
//        categoryResponseData.setMas("请求成功");
//        return categoryResponseData;
//    }
//    @RequestMapping("/add")
//    public String add(){
//        return "backstage/category/category-edit";
//    }
//    @RequestMapping("/update/{id}")
//    public String update(@PathVariable("id") Long id, Model model){
//        Category category = categoryService.findById(id);
//        model.addAttribute("category",category);
//        return "backstage/category/category-edit";
//    }
//    @ResponseBody
//    @RequestMapping("/insert")
//    public boolean insert(Category category){
//        categoryService.insert(category);
//        return true;
//    }
//    @ResponseBody
//    @RequestMapping("/delete/{id}")
//    public boolean delete(@PathVariable("id") Long id){
//        categoryService.deleteById(id);
//        return true;
//    }
//}
