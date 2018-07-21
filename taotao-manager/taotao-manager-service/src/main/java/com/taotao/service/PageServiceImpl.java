package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public EasyUIDataGridResult itemListByPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<TbItem> tbItems = tbItemMapper.selectByExample(new TbItemExample());
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        EasyUIDataGridResult<TbItem> result = new EasyUIDataGridResult<>();
        result.setRows(pageInfo.getList());
        result.setTotal((int) pageInfo.getTotal());
        return result;
    }
}
