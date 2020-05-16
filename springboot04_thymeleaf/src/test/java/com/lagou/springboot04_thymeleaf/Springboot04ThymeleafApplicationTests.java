package com.lagou.springboot04_thymeleaf;

import com.lagou.pojo.Article;
import com.lagou.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot04ThymeleafApplicationTests {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testAll() {

        List<Article> all = articleRepository.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }

}
