package cn.demo.gas.pay.conf;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * sharding-jdbc 配置数据源和分库分表规则
 * 
 * Created by huangjp on 2017/7/19.
 */
@Component
public class ShardingDataSource {

    @Resource
    private DataSource primaryDataSource;

    @Resource
    @Qualifier("secondDataSource")
    private DataSource secondDataSource;

    @Resource
    @Qualifier("threeDataSource")
    private DataSource threeDataSource;

    @Resource
    @Qualifier("fourDataSource")
    private DataSource fourDataSource;

    @Resource
    @Qualifier("fiveDataSource")
    private DataSource fiveDataSource;

    private DataSource shardingDataSource;

    @PostConstruct
    public void init() {

        Map<String, DataSource> map = new HashMap<>(5);
        map.put("gas0", primaryDataSource);
        map.put("gas1", secondDataSource);
        map.put("gas2", threeDataSource);
        map.put("gas3", fourDataSource);
        map.put("gas4", fiveDataSource);

        DataSourceRule dataSourceRule = new DataSourceRule(map);
        List<TableRule> tableRuleList = new ArrayList<>();

        Map<String, DataSource> map1 = new HashMap<>(1);
        map1.put("gas0", primaryDataSource);
        DataSourceRule dataSourceRule1 = new DataSourceRule(map1);

        List<String> pList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            pList.add("recharge" + i);
        }

        tableRuleList.add(new TableRule.TableRuleBuilder("recharge").actualTables(pList).dataSourceRule(dataSourceRule)
                .tableShardingStrategy(new TableShardingStrategy("id", new ModuloTableShardingAlgorithm()))
                .databaseShardingStrategy(new DatabaseShardingStrategy("uid", new ModuloDatabaseShardingAlgorithm()))
                .build());

        tableRuleList.add(new TableRule.TableRuleBuilder("user").actualTables(Arrays.asList("user"))
                .dataSourceRule(dataSourceRule1).build());

        tableRuleList.add(new TableRule.TableRuleBuilder("region").actualTables(Arrays.asList("region"))
                .dataSourceRule(dataSourceRule1).build());

        tableRuleList.add(new TableRule.TableRuleBuilder("account").actualTables(Arrays.asList("account"))
                .dataSourceRule(dataSourceRule1).build());

        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule).tableRules(tableRuleList).build();

        shardingDataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
    }

    public DataSource getShardingDataSource() {
        return shardingDataSource;
    }
}
