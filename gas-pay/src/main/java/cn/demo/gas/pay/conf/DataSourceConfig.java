package cn.demo.gas.pay.conf;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by huangjp on 2017/7/19.
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "threeDataSource")
    @ConfigurationProperties(prefix = "spring.three-datasource")
    public DataSource threeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "fourDataSource")
    @ConfigurationProperties(prefix = "spring.four-datasource")
    public DataSource fourDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "fiveDataSource")
    @ConfigurationProperties(prefix = "spring.five-datasource")
    public DataSource fiveDataSource() {
        return DataSourceBuilder.create().build();
    }
}
