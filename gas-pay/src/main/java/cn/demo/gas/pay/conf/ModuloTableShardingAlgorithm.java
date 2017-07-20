package cn.demo.gas.pay.conf;

import java.util.Collection;
import java.util.LinkedHashSet;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

/**
 * table 分片算法
 *
 * Created by huangjp on 2017/7/19.
 */
public class ModuloTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Integer> {

    @Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<Integer> shardingValue) {
        for (String each : availableTargetNames) {
            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> availableTargetNames,
            ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(availableTargetNames.size());
        Collection<Integer> values = shardingValue.getValues();
        for (Integer value : values) {
            for (String tableNames : availableTargetNames) {
                if (tableNames.endsWith(value % 2 + "")) {
                    result.add(tableNames);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> availableTargetNames,
            ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(availableTargetNames.size());
        Range<Integer> range = shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }

}
