package com.tao.service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@WebAppConfiguration

public class MapperTest {
    @Autowired
    TbItemMapper tbItemMapper;

    @Test
    public void test(){
        TbItemExample example = new TbItemExample();

        example.createCriteria().andSellPointNotLike("三星");

        List<TbItem> tbItems =
                tbItemMapper.selectByExample(example);
    }
}
