package com.bootdo.usermanage.service.impl;

import com.bootdo.common.utils.UuidUtils;
import com.bootdo.usermanage.dao.CompanyDao;
import com.bootdo.usermanage.domain.Applyuser;
import com.bootdo.usermanage.domain.Company;
import com.bootdo.usermanage.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/17
 * Time: 12:44
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyDao companyDao;
    @Override
    public void add(Company company) {
        String uuid = UuidUtils.getUUID32();
        company.setUuid(uuid);
        if(company.getCreatTime()==0) {
            long time = System.currentTimeMillis() / 1000;
            company.setCreatTime(time);
        }
        companyDao.insert(company);
    }

    @Override
    public Company get(String uuid) {

        return  companyDao.queryById(uuid);
    }
    @Override
    public List<Company> list(Map<String, Object> map) {
        List<Company> companyList = companyDao.list(map);
        for(int i =0 ;i<companyList.size();i++){
            companyList.get(i).setId(i+1);
        }
        return companyList;
    }
    @Override
    public int count(Map<String, Object> map) {

        return companyDao.count(map);

    }





    @Override
    public void update(Company company) {
        companyDao.updateByPrimaryKey(company);

    }

    @Override
    public void delete(String id) {
        companyDao.deleteByPrimaryKey(id);
    }


}
