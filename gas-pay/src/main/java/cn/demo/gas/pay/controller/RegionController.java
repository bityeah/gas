package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.model.Region;
import cn.demo.gas.pay.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 省市区
 * Created by zhaohg on 2017/7/26.
 */
@RequestMapping("/region")
@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;


    @RequestMapping("/list")
    public List<Region> getReginList(@PathVariable int parentId) {
        return regionService.getRegionByParentId(parentId);
    }

}
