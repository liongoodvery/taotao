package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.PageResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ContentService contentService;

    @RequestMapping("/content/query/list")
    public EasyUIDataGridResult queryContentList(
            @RequestParam(defaultValue = "0") Long categoryId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer rows
    ) {
        PageResult<TbContent> pageResult = contentService.queryContents(categoryId, page, rows);


        EasyUIDataGridResult result = new EasyUIDataGridResult();

        result.setTotal(pageResult.getTotaolCount());
        result.setRows(pageResult.getData());
        return result;
//        contentService.queryContents()
    }

    @RequestMapping("/content/save")
    public TaotaoResult saveContent(TbContent tbContent) {
        return contentService.saveContent(tbContent);
    }
}
