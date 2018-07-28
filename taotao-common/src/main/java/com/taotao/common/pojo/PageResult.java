package com.taotao.common.pojo;

import java.util.List;

public class PageResult<T> extends TaotaoResult<List<T>> {
    private int totaolCount;
    private int currentPage;
    private int pageCount;

    public int getTotaolCount() {
        return totaolCount;
    }

    public void setTotaolCount(int totaolCount) {
        this.totaolCount = totaolCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
