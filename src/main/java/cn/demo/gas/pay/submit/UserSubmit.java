package cn.demo.gas.pay.submit;

import cn.demo.gas.pay.model.QuerySubmit;

/**
 * Created by zhaohg on 2017/7/27.
 */
public class UserSubmit {

    private Long uid;
    private String whereStr;
    private Integer type;

    private int page = 1;
    private int pageSize = 10;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getWhereStr() {
        return whereStr;
    }

    public void setWhereStr(String whereStr) {
        this.whereStr = whereStr;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setParams(QuerySubmit querySubmit) {
        if (this.page < 1) {
            this.page = 1;
        }
        if (this.pageSize < 10) {
            this.pageSize = 10;
        }
        querySubmit.put("whereStr",whereStr);
        querySubmit.put("type",type);
        querySubmit.setLimit(page, pageSize);
    }

}
