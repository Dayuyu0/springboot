package com.lagou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class LoginController {

    //封装当前年份跳转到登陆页面
    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model){

        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
