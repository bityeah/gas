package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.UserMapper;
import cn.demo.gas.pay.from.UserSubmit;
import cn.demo.gas.pay.model.Account;
import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * Created by huangjp on 2017/7/18.
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public String addUser() {

        final String[] firstName = {"陈", "张", "黄", "周", "胡", "花", "李", "谢", "欧阳", "王", "赵", "霍", "梅"};
        final String[] name = {"冰", "坤", "云", "米", "平", "杰", "静", "鹏", "峰", "涛", "羽", "海", "茹"};

        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            String username = firstName[random.nextInt(firstName.length)] + name[random.nextInt(name.length)];
            User user = new User(username, username, random.nextInt(2) + 1, "18657922592", 1, 0, 0, 0, "address");
            userMapper.insertUser(user);

            Account account = new Account(user.getId(), BigDecimal.ZERO, BigDecimal.ZERO, 1);

            userMapper.insertAccount(account);
        }

        return "Success";
    }

    public List<User> getUserList(UserSubmit submit) {
        QuerySubmit querySubmit = new QuerySubmit();
        submit.setParams(querySubmit);

        return userMapper.getUserList(querySubmit);
    }

    public int getUserCount(UserSubmit submit){
        QuerySubmit querySubmit = new QuerySubmit();
        submit.setParams(querySubmit);

        return userMapper.getUserCount(querySubmit);
    }

    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }

}