package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaohg on 2017/7/26.
 */
@Repository
public interface RegionMapper {

    List<Region> getRegionByParentId(int parentId);

    List<Integer> queryRegionIdList(int level);

    List<Region> loadAll();

//    Region getRegionById(int id);

}
