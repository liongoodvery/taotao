package com.taotao.service;

import com.taotao.common.pojo.PageResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
    PageResult<TbContent> queryContents(Long categoryId, Integer page, Integer rows);

    TaotaoResult saveContent(TbContent tbContent);
}
