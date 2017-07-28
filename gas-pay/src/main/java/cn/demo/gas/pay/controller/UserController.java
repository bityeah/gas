package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.from.UserSubmit;
import cn.demo.gas.pay.model.User;
import cn.demo.gas.pay.service.UserService;
import cn.demo.gas.pay.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huangjp on 2017/7/18.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/add")
    public String addUser() {
        return userService.addUser();
    }


    @RequestMapping("/user/search")
    public Result getUserList(UserSubmit submit) {
        return userService.getUserList(submit);
    }


}