package com.taotao.search.service;

import com.taotao.common.pojo.TaotaoResult;

public interface SearchItemService {
	/**
	 * 导入所有的商品数据到索引库中
	 * @return
	 * @throws Exception
	 */
	public TaotaoResult importAllItems() throws Exception;
}