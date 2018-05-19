package com.bootdo.usermanage.service.impl;

import com.bootdo.usermanage.dao.ApplyuserDao;
import com.bootdo.usermanage.domain.Applyuser;
import com.bootdo.usermanage.service.ApplyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/18
 * Time: 13:55
 */
@Service
public class ApplyuserServiceImpl  implements ApplyUserService {
    @ Autowired
    ApplyuserDao applyuserDao;
    @Override
    public void add(Applyuser applyuser) {
       applyuserDao.insert(applyuser);
    }

    @Override
    public void lock(String uuid) {

    }

    @Override
    public List<Applyuser> list(Map<String, Object> map) {
        List<Applyuser> applyuserList=applyuserDao.list(map);
        return applyuserList;
    }

    @Override
    public void update(Applyuser applyuser) {
        applyuserDao.updateByPrimaryKey(applyuser);
    }

    @Override
    public void delete(String uuid) {
        applyuserDao.deleteByPrimaryKey(uuid);
    }

    @Override
    public Applyuser find(String id) {
        return applyuserDao.selectByPrimaryKey(id);
    }

    @Override
    public int count(Map<String, Object> map) {
        return 0;
    }
}
