package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.TestMapper;
import cn.demo.gas.pay.model.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huangjp on 2017/7/18.
 */
@Service
public class TestService {

    @Resource
    TestMapper testMapper;

    public String helloWorld() {
        Account account = testMapper.getAccount(1);
        return account.toString();
    }

}
