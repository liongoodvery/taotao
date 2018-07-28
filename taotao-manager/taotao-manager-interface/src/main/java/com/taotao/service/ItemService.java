package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
    TaotaoResult saveItem(TbItem item, String desc);

    TaotaoResult updateItem(TbItem item, String desc);

    TaotaoResult deleteItem(Long id);

    TaotaoResult queryDesc(Long id);
}
