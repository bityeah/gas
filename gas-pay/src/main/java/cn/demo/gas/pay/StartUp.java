package cn.demo.gas.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by huangjp on 2017/7/18.
 */
@SpringBootApplication
@MapperScan("cn.demo.gas.pay.dao.mapper")
public class StartUp {

    public static void main(String[] args) {
        SpringApplication.run(StartUp.class, args);
    }

}