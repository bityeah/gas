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

    /**
     * 根据区id 查省市区字符串
     * @param parentId
     * @return
     */

    public String getRegionById(int parentId) {

        String location = "";
        Region region1 = regionMapper.getRegionById(parentId);
        if(region1 != null && region1.getParentId() > 0){
            location = region1.getName() + region1.getSuffix() + location;
            Region region2 = regionMapper.getRegionById(region1.getParentId());
            if(region2 != null && region1.getParentId() > 0){
                location = region2.getName() + region2.getSuffix() + location;
                Region region3 = regionMapper.getRegionById(region2.getParentId());
                if(region3 != null && region1.getParentId() > 0){
                    location = region3.getName() + region3.getSuffix() + location;
                }
            }
        }

        return location;
    }
}
