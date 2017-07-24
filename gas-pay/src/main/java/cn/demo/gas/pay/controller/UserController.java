package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.model.Recharge;
import cn.demo.gas.pay.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huangjp on 2017/7/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/add")
    String addUser() {
        return userService.addUser();
    }

    @RequestMapping("/list")
    List<Recharge> list() {
        return userService.listRecharge();
    }

}