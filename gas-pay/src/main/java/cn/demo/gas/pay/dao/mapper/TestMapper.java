package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by huangjp on 2017/7/18.
 */
@Repository
public interface TestMapper {

    Order getAccount(@Param("id") int id);

    void insertOrder(Order order);

    List<Order> queryOrderList();
}