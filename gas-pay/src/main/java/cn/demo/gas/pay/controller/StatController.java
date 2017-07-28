package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaohg on 2017/7/27.
 */
@RequestMapping("/region")
@RestController
public class RegionController {

    @Autowired
    UserService userService;


    @RequestMapping("/list")
    String addUser() {
        return userService.addUser();
    }
}
