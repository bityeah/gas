package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.TestMapper;
import cn.demo.gas.pay.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * Created by huangjp on 2017/7/18.
 */
@Service
public class TestService {

    @Resource
    TestMapper testMapper;

    public String helloWorld() {
        Order order = testMapper.getAccount(1);
        return order.toString();
    }

    public void insert() {

        for (int i = 1; i < 10000; i++) {

            Order order = new Order();
            order.setId(i);
            order.setUid(new Random().nextInt(10000));
            order.setName("chushou" + i);

            testMapper.insertOrder(order);
        }


    }

    public List<Order> queryOrderList(int page, int pageSize) {
        return testMapper.queryOrderList();
    }
}
