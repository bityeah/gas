package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.Account;
import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by huangjp on 2017/7/18.
 */
@Repository
public interface UserMapper {

    void insertUser(User user);

    void insertAccount(Account account);

    Account getAccountById(Long uid);

    int getUserCount(QuerySubmit submit);

    User getUserById(Long uid);

    List<User> getUserList(QuerySubmit submit);
}
