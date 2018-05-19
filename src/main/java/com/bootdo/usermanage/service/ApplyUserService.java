package com.bootdo.usermanage.service;

import com.bootdo.usermanage.domain.Applyuser;

import java.util.List;
import java.util.Map;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/18
 * Time: 13:46
 */
public interface ApplyUserService {
    /**
     * 添加经济人
     */
    void add(Applyuser applyuser);
    /**
     * 禁用经纪人
     */
    void lock(String uuid);
    /**
     * 查询列表
     */
    List<Applyuser> list(Map<String ,Object> map);
    /**
     * 编辑经济人
     */
     void update(Applyuser applyuser);
    /**
     * 删除经纪人
     */
    void delete(String uuid);
    /**
     * 查询经济人
     */
    Applyuser find(String id);
    /**
     * 查询总数
     */
    int  count (Map<String,Object> map);
}
