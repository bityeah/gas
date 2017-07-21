package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.UserMapper;
import cn.demo.gas.pay.model.Account;
import cn.demo.gas.pay.model.Recharge;
import cn.demo.gas.pay.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by huangjp on 2017/7/18.
 */
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public String addUser() {

        final String[] firstName = {"陈", "张", "黄", "周", "胡", "花", "李", "谢", "欧阳", "王", "赵", "霍", "梅"};
        final String[] name = {"冰", "坤", "云", "米", "平", "杰", "静", "鹏", "峰", "涛", "羽", "海", "茹"};

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String username = firstName[random.nextInt(firstName.length)] + name[random.nextInt(name.length)];
            User user = new User(username, username, random.nextInt(2), "18657922592", 0, 0, "address");
            userMapper.insertUser(user);

            Account account = new Account(user.getId(), BigDecimal.ZERO, 1);

            userMapper.insertAccount(account);
        }

        return "Success";
    }

    public void addRecharge() {

        int k = 10;

        for (int i = 1; i < 1001; i++) {
            new Thread(new ThreadA((i - 1) * k, i * k, userMapper)).start();
        }

    }

}


class ThreadA implements Runnable {

    private int start;
    private int end;
    private final Random random = new Random();
    private UserMapper userMapper;

    public ThreadA(int start, int end, UserMapper userMapper) {
        this.start = start;
        this.end = end;
        this.userMapper = userMapper;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            Recharge recharge = new Recharge(i, random.nextInt(10));
            userMapper.insertRecharge(recharge);
        }
    }
}