package com.hnist.hotel.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Filename
 * @auther 吴星辰;
 * @data 2019/12/11 0:49;
 * @Descripion
 * @Version 1.1.1
 * @Function
 * @History
 */
public class PageParams extends LinkedHashMap<String,Object> {
    //当前页码
    private int page;
    //每页条数
    private int limit;

    public PageParams(Map<String, Object> params){
        this.putAll(params);

        //分页参数
        this.page = Integer.parseInt((String)params.get("page"));
        this.limit = Integer.parseInt((String)params.get("limit"));

        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }

    public PageParams() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
