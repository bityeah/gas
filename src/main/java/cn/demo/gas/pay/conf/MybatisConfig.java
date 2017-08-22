package cn.demo.gas.pay.conf;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * mybatis的配置
 *
 * Created by huangjp on 2017/7/19.
 */
@Configuration
public class MybatisConfig {

    @Resource
    private ShardingDataSource shardingDataSource;

    @Bean
    public SqlSessionFactoryBean createShardingSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "mybatis/*.xml";
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(shardingDataSource.getShardingDataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("cn.demo.gas.pay.model");
        return sqlSessionFactoryBean;
    }
}
