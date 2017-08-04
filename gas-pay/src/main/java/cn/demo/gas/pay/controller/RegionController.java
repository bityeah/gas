package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.service.RegionService;
import cn.demo.gas.pay.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 省市区
 * Created by zhaohg on 2017/7/26.
 */
@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;


    @RequestMapping("/region/list")
    public Result getRegionList(int parentId) {
        return regionService.getRegionByParentId(parentId);
    }

}
