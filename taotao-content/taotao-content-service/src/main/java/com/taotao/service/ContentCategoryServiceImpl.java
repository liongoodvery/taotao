package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper mapper;

    public List<EasyUITreeNode> getContentCategoryList(long parentId) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> list = mapper.selectByExample(example);
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            //添加到列表
            resultList.add(node);
        }
        return resultList;

    }

    @Override
    public TaotaoResult createContentCategory(Long parentId, String name) {
        TbContentCategory category = new TbContentCategory();
        category.setCreated(new Date());
        category.setIsParent(false);
        category.setName(name);
        category.setParentId(parentId);
        category.setSortOrder(1);
        category.setStatus(1);
        category.setUpdated(category.getCreated());
        mapper.insertSelective(category);

        TbContentCategory parent = mapper.selectByPrimaryKey(parentId);
        if (!parent.getIsParent()) {
            parent.setIsParent(true);
            mapper.updateByPrimaryKeySelective(parent);
        }
        return TaotaoResult.ok(category);
    }

    @Override
    public TaotaoResult updateContentCategory(Long contentId, String name) {
        TbContentCategory category = mapper.selectByPrimaryKey(contentId);
        if (category == null) {
            return new TaotaoResult(100009, "not exist", null);
        }

        category.setName(name);
        category.setUpdated(new Date());

        mapper.updateByPrimaryKeySelective(category);

        return TaotaoResult.ok(category);
    }

    @Override
    public TaotaoResult deleteContentCategory(Long contentId, String name) {
        TbContentCategory category = mapper.selectByPrimaryKey(contentId);

        Long parentId = category.getParentId();

        TbContentCategory parent = mapper.selectByPrimaryKey(parentId);
        if (parent != null) {
            TbContentCategoryExample example = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            int count = mapper.countByExample(example);
            if (count == 1) {
                parent.setIsParent(false);
                mapper.updateByPrimaryKey(parent);
            }
        }

        int result = mapper.deleteByPrimaryKey(contentId);
        return result > 0 ? TaotaoResult.ok() : new TaotaoResult(2200, "delete Failed", null);
    }
}
