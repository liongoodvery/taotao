package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;

public interface PageService {
    EasyUIDataGridResult itemListByPage(Integer page, Integer rows);
}
