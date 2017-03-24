package com.guochunhao.springframework.boot.controller;

import com.guochunhao.springframework.boot.model.User;
import com.guochunhao.springframework.boot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by count on 17/3/23.
 */
@Controller
public class HelloController
{
    private static Logger logger = Logger.getLogger(HelloController.class);


    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "guochunhao") String name, Model model)
    {
        logger.info(name);

        User user = userService.selectOne(1);

        model.addAttribute("name", name);
        model.addAttribute("name", user.getUsername());

        return "hello";
    }

}
