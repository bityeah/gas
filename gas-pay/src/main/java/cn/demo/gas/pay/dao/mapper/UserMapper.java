package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.Account;
import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by huangjp on 2017/7/18.
 */
@Repository
public interface UserMapper {

    void insertUser(User user);

    void insertAccount(Account account);

    Account getAccountById(Long uid);

    long getUserCount(QuerySubmit submit);

    User getUserById(Long uid);

    List<User> getUserList(QuerySubmit submit);

    //T分个人用户还是商业用户 获取昨天的新增用户总数
    long getUserTypeCount(Map<String, Object> map);
}
