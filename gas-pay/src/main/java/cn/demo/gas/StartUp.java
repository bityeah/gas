package cn.demo.gas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by huangjp on 2017/7/18.
 */
@SpringBootApplication
@MapperScan(value = "cn.demo.gas.pay.dao.mapper")
@EnableScheduling
public class StartUp {

    public static void main(String[] args) {
        SpringApplication.run(StartUp.class, args);
    }

}