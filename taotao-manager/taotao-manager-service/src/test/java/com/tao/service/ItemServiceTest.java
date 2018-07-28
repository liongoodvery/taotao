package com.tao.service;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test_*.xml")
@Rollback
@Transactional
public class ItemServiceTest {
    @Autowired
    ItemService itemService;

    @Test
    public void test16() throws Exception {
        TbItem item = new TbItem();
        item.setTitle("fasdfasd");
        item.setPrice(1010L);
        item.setNum(100);
        item.setCid(20L);
        itemService.saveItem(item, "desc_desc");
        System.out.println(ToStringBuilder.reflectionToString(item));
    }
}
