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

    private DataSource shardingDataSource;

    @PostConstruct
    public void init() {

        Map<String, DataSource> map = new HashMap<>(2);
        map.put("gas0", primaryDataSource);
        map.put("gas1", secondDataSource);

        DataSourceRule dataSourceRule = new DataSourceRule(map);
        List<TableRule> tableRuleList = new ArrayList<>();
        List<String> pList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            pList.add("order" + i);
        }
        tableRuleList.add(new TableRule.TableRuleBuilder("order").actualTables(pList).dataSourceRule(dataSourceRule)
                .tableShardingStrategy(new TableShardingStrategy("id", new ModuloTableShardingAlgorithm())).build());

        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule)
                .databaseShardingStrategy(
                        new DatabaseShardingStrategy("uid", new ModuloDatabaseShardingAlgorithm()))
                .tableRules(tableRuleList).build();

        shardingDataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
    }

    public DataSource getShardingDataSource() {
        return shardingDataSource;
    }
}
