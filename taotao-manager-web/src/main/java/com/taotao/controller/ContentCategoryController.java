package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content/category")
public class ContentCategoryController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<EasyUITreeNode> getContentCatList(
            @RequestParam(value = "id", defaultValue = "0") Long parentId) {

        List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
        return list;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public TaotaoResult createContentCategory(Long parentId, String name) {
        return contentCategoryService.createContentCategory(parentId, name);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public TaotaoResult updateContentCategory(Long id, String name) {
        return contentCategoryService.updateContentCategory(id, name);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public TaotaoResult deleteContentCategory(Long id, String name) {
        return contentCategoryService.deleteContentCategory(id, name);
    }
}
