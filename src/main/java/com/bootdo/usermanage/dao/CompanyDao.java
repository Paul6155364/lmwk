package com.bootdo.usermanage.dao;

import com.bootdo.usermanage.domain.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface CompanyDao {
    int deleteByPrimaryKey(String uuid);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String uuid);

    Company queryById(String id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company>  list(Map<String, Object> map);
    int count(Map<String, Object> map);
}