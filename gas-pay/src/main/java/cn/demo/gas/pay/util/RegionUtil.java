package cn.demo.gas.pay.util;

import cn.demo.gas.pay.dao.mapper.RegionMapper;
import cn.demo.gas.pay.model.Region;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangjp on 2017/8/4.
 */
@Component
public class RegionUtil {

    @Resource
    private RegionMapper regionMapper;

    public static List<Region> regionList;

    @PostConstruct
    public void init() {
        regionList = regionMapper.loadAll();
    }

    public static List<Integer> queryIdListByLevel(int level) {

        List<Integer> idList = new ArrayList<>();
        for (Region region : regionList) {
            if (region.getLevel() == level) {
                idList.add(region.getId());
            }
        }

        return idList;
    }

    public static List<Integer> queryIdListByParentId(int parentId) {
        List<Integer> idList = new ArrayList<>();
        for (Region region : regionList) {
            if (region.getParentId() == parentId) {
                idList.add(region.getId());
            }
        }

        return idList;
    }
}
