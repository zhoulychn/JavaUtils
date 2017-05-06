package com.zhoulychn.controller;

import com.zhoulychn.bean.entity.AnchorBase;
import com.zhoulychn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

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
    private TestService testService;

    @RequestMapping("/query")
    public String query(Model model, HttpServletRequest request) {
        WebApplicationContext webContext = ContextLoader.getCurrentWebApplicationContext();
        AnchorBase userBase = testService.selectById("https://www.douyu.com/10");
        model.addAttribute("user", userBase);
        System.out.println(new Date());
        return "/test";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        AnchorBase userBase = testService.selectById("https://www.douyu.com/10");
        userBase.setState("0");
        testService.update(userBase);
        model.addAttribute("user", userBase);
        System.out.println(new Date());
        return "/test";
    }

    @RequestMapping("/transaction")
    public String transaction(Model model) {
        try {
            testService.transactionCase();
        } catch (Exception e) {
            System.out.println("------------------异常-------------------");
        }
        AnchorBase userBase = testService.selectById("https://www.douyu.com/10");
        model.addAttribute("user", userBase);
        return "/test";
    }
}
