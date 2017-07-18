package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by huangjp on 2017/7/18.
 */
@Mapper
@Component
public interface TestMapper {

    Account getAccount(@Param("id") int id);

}