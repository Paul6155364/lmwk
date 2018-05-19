package com.bootdo.usermanage.service;

import java.io.Serializable;
import java.util.List;

/**
 * create with idea
 * author: xiaoniao
 * Date: 2018/5/17
 * Time: 12:27
 */
public interface ComService<T extends Serializable,ID extends Serializable> {
    T get(ID var1);
    int insert(T var1);
    int[] insertBatch(List<T> var1);
    void update(T var1);
    int delete(ID var1);
}
