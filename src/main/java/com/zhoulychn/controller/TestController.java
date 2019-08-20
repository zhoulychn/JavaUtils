package com.zhoulychn.controller;

import com.zhoulychn.entity.UserEntity;
import com.zhoulychn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lewis on 2016/12/20.
 * 测试类
 */

@Controller
public class TestController {

    private final AtomicLong count = new AtomicLong(0);

    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    public String query(Model model, HttpServletRequest request) {
        UserEntity entity = userService.selectById(1);
        model.addAttribute("user", entity);
        System.out.println(new Date());
        return "/test";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        UserEntity entity = userService.selectById(1);
        userService.update(entity);
        model.addAttribute("user", entity);
        System.out.println(new Date());
        return "/test";
    }

    @RequestMapping("/transaction")
    public String transaction(Model model) {
        try {
            userService.transactionCase();
        } catch (Exception e) {
            System.out.println("------------------异常-------------------");
        }
        UserEntity entity = userService.selectById(1);
        model.addAttribute("user", entity);
        return "/test";
    }
}
