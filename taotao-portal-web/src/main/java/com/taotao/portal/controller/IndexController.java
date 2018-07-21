package com.taotao.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    Logger logger = LoggerFactory.getLogger(IndexController.class.getName());

    @RequestMapping("/index")
    public String index() {
        logger.warn("index vistited");
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
