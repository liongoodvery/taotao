package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/save")
    public TaotaoResult saveItem(TbItem tbItem, String desc) {
        return itemService.saveItem(tbItem, desc);
    }


}
