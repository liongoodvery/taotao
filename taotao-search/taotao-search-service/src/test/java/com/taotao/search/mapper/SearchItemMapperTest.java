package com.taotao.search.mapper;

import com.github.pagehelper.PageHelper;
import com.taotao.common.pojo.SearchItem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
@Rollback
@Transactional
public class SearchItemMapperTest {
    @Autowired
    private SearchItemMapper mapper;

    @Test
    public void testGetSearchItemList() throws Exception {
        PageHelper.startPage(1, 20);
        List<SearchItem> list = mapper.getSearchItemList();

        Assert.assertTrue(list.size() ==20);


    }
}
