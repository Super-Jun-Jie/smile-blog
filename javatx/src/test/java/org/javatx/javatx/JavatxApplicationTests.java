package org.javatx.javatx;

import org.javatx.log.Log;
import org.javatx.log.LogMapper;
import org.javatx.pojo.Article;
import org.javatx.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavatxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ArticleService articleService;
    @Autowired
    private LogMapper logMapper;
    @Test
    void articleTest(){
        List<Article> article = articleService.findAll();
        article.forEach(System.out::println);
    }
    @Test
    void logTest(){
        Log log = new Log();
        log.setTitle("胡俊杰");
        logMapper.save(log);

    }

}
