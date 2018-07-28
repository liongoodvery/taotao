package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {
    List<EasyUITreeNode> getContentCategoryList(long parentId);

    TaotaoResult createContentCategory(Long parentId, String name);


    TaotaoResult updateContentCategory(Long contentId, String name);


    TaotaoResult deleteContentCategory(Long contentId, String name);
}
