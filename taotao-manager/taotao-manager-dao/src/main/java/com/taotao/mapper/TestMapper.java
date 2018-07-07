package com.taotao.mapper;

import org.apache.ibatis.annotations.Select;


public interface TestMapper {
    @Select("select NOW()")
    String queryNow();
}
