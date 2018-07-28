package com.taotao.common.pojo.com.taotao.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Serializable> {
    T findItemById(Long id);

    List<T> findItems(int start, int count);

    T updateItem(T t);

    T saveItem(T t);
}
