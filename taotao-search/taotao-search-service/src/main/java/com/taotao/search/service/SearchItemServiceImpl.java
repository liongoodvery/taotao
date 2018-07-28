package com.taotao.search.service;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.mapper.SearchItemMapper;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchItemServiceImpl implements SearchItemService {
    @Autowired
    private SearchItemMapper searchItemMapper;

    @Autowired
    private SolrServer solrServer;

    /**
     * 导入所有的商品数据到索引库中
     *
     * @return
     * @throws Exception
     */
    public TaotaoResult importAllItems() throws Exception {
        // 1、查询所有商品数据。
        List<SearchItem> itemList = searchItemMapper.getSearchItemList();
        // 2、创建一个SolrServer对象。
        // 3、为每个商品创建一个SolrInputDocument对象。
        for (SearchItem searchItem : itemList) {
            SolrInputDocument document = new SolrInputDocument();
            // 4、为文档添加域
            document.addField("id", searchItem.getId());
            document.addField("item_title", searchItem.getTitle());
            document.addField("item_sell_point", searchItem.getSell_point());
            document.addField("item_price", searchItem.getPrice());
            document.addField("item_image", searchItem.getImage());
            document.addField("item_category_name", searchItem.getCategory_name());
            document.addField("item_desc", searchItem.getItem_desc());
            // 5、向索引库中添加文档。
            solrServer.add(document);
        }
        //提交修改
        solrServer.commit();
        // 6、返回TaotaoResult。
        return TaotaoResult.ok();
    }
}