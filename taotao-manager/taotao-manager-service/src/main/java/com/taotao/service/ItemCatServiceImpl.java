package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper mapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCats = mapper.selectByExample(example);
        ArrayList<EasyUITreeNode> nodes = new ArrayList<>();

        for (TbItemCat tbItemCat : tbItemCats) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setState(tbItemCat.getIsParent()? "closed" : "open");
            node.setText(tbItemCat.getName());
            nodes.add(node);
        }
        return nodes;
    }
}
