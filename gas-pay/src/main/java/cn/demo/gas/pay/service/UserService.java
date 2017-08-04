package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.RegionMapper;
import cn.demo.gas.pay.dao.mapper.UserMapper;
import cn.demo.gas.pay.from.UserForm;
import cn.demo.gas.pay.model.Account;
import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.User;
import cn.demo.gas.pay.util.RegionUtil;
import cn.demo.gas.pay.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by huangjp on 2017/7/18.
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public String addUser() {

        final String[] firstName = {"陈", "张", "黄", "周", "胡", "花", "李", "谢", "欧阳", "王", "赵", "霍", "梅"};
        final String[] name = {"冰", "坤", "云", "米", "平", "杰", "静", "鹏", "峰", "涛", "羽", "海", "茹", "结"};

        final String[] community = {"西溪花城", "慧仁家园北区", "五联西苑", "迎春小区", "滨心小区", "蒋村花园"};
        final String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        final String[] unit = {"1", "2", "3"};
        final String[] homeNum = {"201", "301", "402", "902", "701", "602", "501"};

        Random random = new Random();

        List<Integer> idList = RegionUtil.queryIdListByLevel(1);

        for (int i = 0; i < 2000000; i++) {

            int provinceId = idList.get(random.nextInt(idList.size()));
            int cityId = randomRegionIdByParentId(random, provinceId);
            int areaId = randomRegionIdByParentId(random, cityId);
            String username = firstName[random.nextInt(firstName.length)] + name[random.nextInt(name.length)];

            String address = community[random.nextInt(community.length)] + num[random.nextInt(num.length)] + "幢"
                    + unit[random.nextInt(unit.length)] + "单元" + homeNum[random.nextInt(homeNum.length)];

            User user = new User(username, username, random.nextInt(2) + 1, getPhone(random), 1, provinceId, cityId, areaId, address);
            userMapper.insertUser(user);

            Account account = new Account(user.getId(), BigDecimal.ZERO, BigDecimal.ZERO, 1);

            userMapper.insertAccount(account);
        }

        return "Success";
    }

    public int randomRegionIdByParentId(Random random, int parentId) {
        List<Integer> list = RegionUtil.queryIdListByParentId(parentId);
        if (!list.isEmpty()) {
            return list.get(random.nextInt(list.size()));
        }

        return 0;
    }

    private String getPhone(Random random) {
        return "186" + random.nextInt(100000000);
    }

    public Result getUserList(UserForm submit) {
        QuerySubmit querySubmit = new QuerySubmit();
        submit.setParams(querySubmit);

        List<User> list = userMapper.getUserList(querySubmit);

        return new Result(list);
    }

    public int getUserCount(UserForm submit){
        QuerySubmit querySubmit = new QuerySubmit();
        submit.setParams(querySubmit);

        return userMapper.getUserCount(querySubmit);
    }

    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }

}