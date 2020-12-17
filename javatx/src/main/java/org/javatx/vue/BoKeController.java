package org.javatx.vue;

import javafx.animation.Timeline;
import org.javatx.mapper.TagsMapper;
import org.javatx.pojo.Article;
import org.javatx.pojo.Category;
import org.javatx.result.ResultData;
import org.javatx.result.ResultEnum;
import org.javatx.service.ArticleService;
import org.javatx.service.CategoryService;
import org.javatx.utils.ToolUtil;
import org.javatx.vue.bean.ArticleTimelineDto;
import org.javatx.vue.bean.TimelineDto;
import org.javatx.vue.bean.TimelineListDto;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/2 14:49
 */
@RestController
public class BoKeController {

    private final ArticleService articleService;
    private final CategoryService categoryService;
    private final TagsMapper tagsMapper;

    public BoKeController(ArticleService articleService, CategoryService categoryService, TagsMapper tagsMapper) {
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.tagsMapper = tagsMapper;
    }

    @GetMapping(value = "article",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<Article> findAll(@RequestParam(defaultValue = "") String query, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "1")Integer pageSize){
        Page<Article> articlePage = articleService.vueSearch(query,pageNum-1,pageSize);
        return new ResultData<>(ResultEnum.SUCCESS,articlePage.getContent(),articlePage.getTotalElements());
    }

    @GetMapping(value = "categoryList",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<Category> categoryList(){
        return new ResultData<>(ResultEnum.SUCCESS,categoryService.findAll());
    }

    @GetMapping(value = "getArticleList",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<Article> getArticleList(String keyWord){


        return new ResultData<>(ResultEnum.SUCCESS,articleService.findAll(keyWord));
    }






    @DeleteMapping(value = "article/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<Article> deleteById(@PathVariable("id") Long id){
        articleService.delete(id);
        return new ResultData<>(ResultEnum.SUCCESS);
    }




    @GetMapping(value = "category",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<Category> categoryFindAll( @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "1")Integer pageSize){
        Page<Category> categoryPage = categoryService.getCategoryList(pageNum-1,pageSize);
        return new ResultData<>(ResultEnum.SUCCESS,categoryPage.getContent(),categoryPage.getTotalElements());
    }

    @DeleteMapping(value = "category/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<Category> categoryDeleteById(@PathVariable("id") Long id){
        categoryService.delete(id);
        return new ResultData<>(ResultEnum.SUCCESS);
    }



    @PostMapping(value = "category",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<Category> addCategory(@RequestBody Category category){
        categoryService.insert(category);
        return new ResultData<>(ResultEnum.SUCCESS);
    }

    @PostMapping(value = "article",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<Article> addArticle(@RequestBody Article article){
        article.setContent(ToolUtil.removeHtml(article.getHtmlContent()));
        article.setCreator("胡俊杰");
        articleService.insert(article);
        return new ResultData<>(ResultEnum.SUCCESS);
    }

    //标签
    @GetMapping("getTagList")
    public ResultData<String> getTagList(){
        List<String> list = tagsMapper.getTagsByArticleId(null);
        return new ResultData<>(ResultEnum.SUCCESS,list);
    }

    //时间轴  年份 日期 标题 点击链接跳转
    @GetMapping(value = "getTimeline",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<TimelineListDto> getTimeline(){
        Map<String, List<ArticleTimelineDto>> map = saveFormat(articleService.getTimeline());
        return new ResultData<>(ResultEnum.SUCCESS,map.keySet().stream().map(a -> new TimelineListDto(a, map.get(a))).collect(Collectors.toList()).stream().sorted(Comparator.comparing(param ->4000- Integer.parseInt(param.getYear()))).collect(Collectors.toList()));
    }


    public Map<String,List<ArticleTimelineDto>> saveFormat(List<TimelineDto> list){
        Map<String,List<ArticleTimelineDto>> map = new HashMap<>();
        list.forEach(a->{


            ArticleTimelineDto articleTimelineDto = new ArticleTimelineDto(a.getTitle(), a.getArticleId());

            if (!map.containsKey(a.getYear())){
                List<ArticleTimelineDto> articleTimelineDtoList = new ArrayList<>();
                articleTimelineDtoList.add(articleTimelineDto);
                map.put(a.getYear(),articleTimelineDtoList);
            }else {
                List<ArticleTimelineDto> timelineDtoList = map.get(a.getYear());
                timelineDtoList.add(articleTimelineDto);
                map.put(a.getYear(),timelineDtoList);
            }
        });

        return map;

    }
}

