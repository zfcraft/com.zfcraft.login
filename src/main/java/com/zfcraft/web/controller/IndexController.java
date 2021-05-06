package com.zfcraft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chen
 * 2020/3/13.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String Index(){
        return "login";
    }

    @RequestMapping("/registerPage")
    public String index(){
        return "register";
    }
}
