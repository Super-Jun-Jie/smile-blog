package org.javatx.controller;

import org.javatx.pojo.Article;
import org.javatx.pojo.Carousel;
import org.javatx.pojo.ResponseData;
import org.javatx.service.CarouselService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/9 9:05
 */
@Controller
@RequestMapping("/carousel")
public class CarouselController {
    private final CarouselService carouselService;
    public CarouselController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }
    @ResponseBody
    @RequestMapping("/findAll")
    public ResponseData<Carousel> findAll(Carousel carousel, Integer page, Integer limit){
        Page<Carousel> carousels = carouselService.search(carousel,page-1,limit);
        ResponseData<Carousel> carouselResponseData = new ResponseData<>();
        carouselResponseData.setCode("0");
        carouselResponseData.setCount(carousels.getTotalElements());
        carouselResponseData.setData(carousels.getContent());
        carouselResponseData.setMas("请求成功");
        return carouselResponseData;
    }
    @RequestMapping("/list")
    public String list(){
        return "backstage/carousel/carousel-list";
    }
    @RequestMapping("/add")
    public String add(){
        return "backstage/carousel/carousel-edit";
    }
    @ResponseBody
    @RequestMapping("/insert")
    public boolean insert(Carousel carousel){
        carouselService.save(carousel);
        return true;
    }
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        carouselService.deleteById(id);
        return true;
    }
}
