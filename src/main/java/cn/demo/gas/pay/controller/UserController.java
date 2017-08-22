package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.submit.UserSubmit;
import cn.demo.gas.pay.service.UserService;
import cn.demo.gas.pay.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangjp on 2017/7/18.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Deprecated
//    @RequestMapping("/user/add")
    public String addUser() {
        return userService.addUser();
    }


    @RequestMapping("/user/list")
    public Result getUserList(UserSubmit submit) {
        return userService.getUserList(submit);
    }

    @RequestMapping("/user/info")
    public Result getUserById(long uid) {
        return userService.getUserById(uid);
    }

}