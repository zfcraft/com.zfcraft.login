package com.zfcraft.web.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import com.zfcraft.web.Exception.LoginException;
import com.zfcraft.web.entity.User;
import com.zfcraft.web.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.zfcraft.web.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    private LineCaptcha lineCaptcha;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id) {
        return userService.Sel(id).toString();
    }

    @RequestMapping("/login")
    public String adminLogin(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "imgText") String imgText){

// 取得用户信息
        User user = userService.getUserInfo(username);
        if (user == null) {
            throw  new LoginException(ResultEnum.USER_ALREADY_EXISTED);
        }
        if (!imgText.equals(lineCaptcha.getCode())){
            throw  new LoginException(ResultEnum.USER_ALREADY_EXISTED);
        }

        if (username.equals(user.getUserName()) && (password).equals(user.getPassWord()) && imgText.equals(lineCaptcha.getCode())) {
//            return "redirect:hello";
            return "success";
        } else {
//            return "redirect:toLogin";
            return "error";
        }


//        if (userService.checkAdminUsername(username, password)) {
//
//            return "redirect:/testBoot/userIndex";
//        }
//        return "error";
    }


    @RequestMapping("/register")
    public String register(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password) {

        User Resultuser = userService.getTbadminUserInfo(username);

        if (Resultuser != null) {
            throw new LoginException(ResultEnum.USER_ALREADY_EXISTED);
        }
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        if (userService.register(user) > 0) {

            return "login";
        }
        return "register";
    }


    /**
     * thymeleaf模板
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/userIndex")
    public  ModelAndView findAllUser(ModelAndView modelAndView) {
        //设置返回的页面名称
        modelAndView.setViewName("user");
        //要返回在页面的数据
            List<User> userList =  userService.findAllUser();
            modelAndView.addObject("userList", userList);
        System.out.println("userList = " + userList);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
//        userService.delete(id);
        return "redirect:/userList";
    }


    /**
     * 生成验证码
     * @param response
     */
    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response) {
        // 随机生成 4 位验证码
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        // 定义图片的显示大小
        lineCaptcha = CaptchaUtil.createLineCaptcha(100, 30);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            // 调用父类的 setGenerator() 方法，设置验证码的类型
            lineCaptcha.setGenerator(randomGenerator);
            // 输出到页面
            lineCaptcha.write(response.getOutputStream());
            // 打印日志
//            logger.info("生成的验证码:{}", lineCaptcha.getCode());
            // 关闭流
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}