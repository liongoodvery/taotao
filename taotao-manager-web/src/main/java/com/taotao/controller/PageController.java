package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PageService pageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String page(@PathVariable("page") String page) {
        return page;
    }


    @RequestMapping(value = "/item-add", method = RequestMethod.GET)
    public String itemAdd() {
        return "item-add";
    }

    @RequestMapping(value = "/item/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult itemListByPage(Integer page, Integer rows) {
        if (page == null) page = 1;
        if (rows == null) rows = 30;
        return pageService.itemListByPage(page, rows);
    }
}
