package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.RegionMapper;
import cn.demo.gas.pay.model.Region;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhaohg on 2017/7/27.
 */
@Service
public class RegionService {

    @Resource
    private RegionMapper regionMapper;

    /**
     * 获取省市区
     * @param parentId 父id
     * @return
     */
    public List<Region> getRegionByParentId(int parentId) {
        return regionMapper.getRegionByParentId(parentId);
    }

}
