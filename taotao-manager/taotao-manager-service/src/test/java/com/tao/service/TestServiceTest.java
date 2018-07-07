package com.tao.service;

import com.taotao.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@WebAppConfiguration

public class TestServiceTest {
    @Autowired
    TestService testService;

    @Test
    public void testQueryNow() {
        System.out.println(testService.queryNow());
    }
}
