package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.PageResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public PageResult<TbContent> queryContents(Long categoryId, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        TbContentExample example = new TbContentExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        List<TbContent> tbContents = tbContentMapper.selectByExample(example);
        PageInfo<TbContent> pageInfo = new PageInfo<>(tbContents);
        PageResult<TbContent> result = new PageResult<>();
        result.setCurrentPage(pageInfo.getPageSize());
        result.setTotaolCount((int) pageInfo.getTotal());
        result.setPageCount(pageInfo.getPageSize());
        result.setStatus(0);
        result.setData(Collections.unmodifiableList(tbContents));
        return result;
    }


    @Override
    public TaotaoResult saveContent(TbContent tbContent) {
        TaotaoResult taotaoResult = null;
        try {

            Date date = new Date();
            tbContent.setCreated(date);
            tbContent.setUpdated(date);
            int i = tbContentMapper.insertSelective(tbContent);
            if (i == 1) {
                taotaoResult = TaotaoResult.ok();
            } else {
                throw new RuntimeException("insert failed");
            }
        } catch (Exception e) {
            taotaoResult = TaotaoResult.build(-1, e.getMessage());
        }

        return taotaoResult;
    }
}
