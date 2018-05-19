package com.bootdo.usermanage.dao;

import com.bootdo.usermanage.domain.Applyuser;

import java.util.List;
import java.util.Map;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/17
 * Time: 18:24
 */
public interface ApplyuserDao {
    int deleteByPrimaryKey(String uuid);

    int insert(Applyuser record);

    int insertSelective(Applyuser record);

    Applyuser selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Applyuser record);

    int updateByPrimaryKey(Applyuser record);

    List<Applyuser> list(Map<String ,Object> map);

    int  count (Map<String,Object> map);
}
