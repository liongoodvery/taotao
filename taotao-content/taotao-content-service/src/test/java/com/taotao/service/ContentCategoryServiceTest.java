package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = "classpath:spring/test_applicationContext-*.xml")
public class ContentCategoryServiceTest {
    @Autowired
    ContentCategoryService service;

    @Test
    public void test13() throws Exception {
        List<EasyUITreeNode> categoryList = service.getContentCategoryList(0L);
        String s = ToStringBuilder.reflectionToString(categoryList, ToStringStyle.MULTI_LINE_STYLE);
        System.out.println(s);
    }
}
