package com.taotao.service;

import com.taotao.common.pojo.PageResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = "classpath:spring/test_applicationContext-*.xml")
@Transactional
@Rollback
public class ContentServiceTest {
    @Autowired
    ContentService contentService;

    @Test
    public void testQuery() throws Exception {
        PageResult<TbContent> result = contentService.queryContents(89L, 1, 20);
        for (TbContent tbContent : result.getData()) {
//            System.out.println(ToStringBuilder.reflectionToString(tbContent));
        }
    }

    @Test
    public void testSave() throws Exception {
        PageResult<TbContent> result = contentService.queryContents(89L, 1, 20);
        TbContent tbContent = result.getData().get(0);
        tbContent.setId(null);
        tbContent.setTitleDesc("aaaaaaaaa");
        tbContent.setTitle("ddddddddddddddd");
        TaotaoResult taotaoResult = contentService.saveContent(tbContent);
        Assert.assertTrue(taotaoResult.getStatus() == 200);
        Assert.assertNotNull(tbContent.getId());
    }
}
