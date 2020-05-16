package com.lagou.controller;

import com.lagou.pojo.Article;
import com.lagou.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/list")
    public String list(Model model,
                       @PageableDefault(
                               page = 0,
                               value = 3,
                               sort = {"created"},
                               direction = Sort.Direction.DESC)Pageable pageable){
        Page<Article> page = articleRepository.findAll(pageable);
        model.addAttribute("pageInfo",page);
        return "client/index";
    }
}
