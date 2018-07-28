package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TaotaoResult saveItem(TbItem item, String desc) {

        long itemId = IDUtils.genItemId();
        item.setId(itemId);
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setUpdated(date);
        item.setCreated(date);

        tbItemMapper.insertSelective(item);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDesc.setItemDesc(desc);

        tbItemDescMapper.insertSelective(tbItemDesc);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateItem(TbItem item, String desc) {
        Long id = item.getId();
        if (id == null) {
            return TaotaoResult.build(404, "not exist item");
        }

        TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
        if (null == tbItem) {
            return TaotaoResult.build(404, "not exist item");

        }

        if (!StringUtils.isEmpty(item.getBarcode())) {
            tbItem.setBarcode(item.getBarcode());
        }
        if (!StringUtils.isEmpty(item.getSellPoint())) {
            tbItem.setSellPoint(item.getSellPoint());
        }
        if (!StringUtils.isEmpty(item.getImage())) {
            tbItem.setImage(item.getImage());
        }
        if (!StringUtils.isEmpty(item.getTitle())) {
            tbItem.setTitle(item.getTitle());
        }
        if (null != item.getCid()) {
            tbItem.setCid(item.getCid());
        }

        if (null != item.getPrice()) {
            tbItem.setPrice(item.getPrice());
        }

        if (null != item.getNum()) {
            tbItem.setNum(item.getNum());
        }


        Date updated = new Date();
        tbItem.setUpdated(updated);

        tbItemMapper.updateByPrimaryKeySelective(tbItem);


        if (!StringUtils.isEmpty(desc)) {
            TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(id);
            tbItemDesc.setItemDesc(desc);
            tbItemDesc.setUpdated(updated);
            tbItemDescMapper.updateByPrimaryKey(tbItemDesc);
        }

        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteItem(Long id) {
        if (id != null) {

            tbItemMapper.deleteByPrimaryKey(id);
            return TaotaoResult.ok();

        }
        return TaotaoResult.build(404, "not exist item");
    }

    @Override
    public TaotaoResult queryDesc(Long id) {
        TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(id);
        return TaotaoResult.build(0, "", tbItemDesc);
    }
}
