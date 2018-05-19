package com.bootdo.usermanage.service;

import com.bootdo.usermanage.domain.Company;


import java.util.List;
import java.util.Map;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/17
 * Time: 12:17
 */

public interface CompanyService {
    /**
     * 添加公司
     *
     */
    void add(Company company);
    /**
     * 查询公司
     */
    Company get(String id);
    /**
     * 查询所有公司
     */

    List<Company> list( Map<String, Object> map);
    int  count (Map<String, Object> map);
    /**
     * 更新公司
     */
    void update(Company company);
    /**
     * 逻辑删除
     * 删除公司
     */
    void delete(String id);

}
