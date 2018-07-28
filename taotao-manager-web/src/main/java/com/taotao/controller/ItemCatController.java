package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ItemCatService itemCatService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<EasyUITreeNode> getItemCatList(
            @RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return itemCatService.getItemCatList(parentId);
    }

}
