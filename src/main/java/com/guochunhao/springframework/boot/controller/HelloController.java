package com.guochunhao.springframework.boot.controller;

import com.guochunhao.springframework.boot.model.User;
import com.guochunhao.springframework.boot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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

        User user = userService.selectOne(24);

        model.addAttribute("name", name);
        model.addAttribute("name", user.getUsername());

        return "hello";
    }


    /**
     * 查询用户集合
     *
     * @param response
     */
    @RequestMapping("/add")
    public void addUser(HttpServletResponse response)
    {
        logger.info("add用户开始");

        User user = new User();
        user.setAddress("南京市");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setUsername("guochunhao");
        try
        {
            userService.addUser(user);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
