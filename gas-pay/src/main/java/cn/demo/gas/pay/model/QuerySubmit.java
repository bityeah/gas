package cn.demo.gas.pay.model;

/**
 * Created by zhaohg on 2017/7/27.
 */

import cn.demo.gas.pay.util.Util;

import java.util.HashMap;
import java.util.Map;

public class QuerySubmit extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    private static final String LIMIT_START = "start";
    private static final String LIMIT_END = "end";

    public QuerySubmit(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public QuerySubmit(int initialCapacity) {
        super(initialCapacity);
    }

    public QuerySubmit() {
        super(5);
        super.put(LIMIT_START, 0);
        super.put(LIMIT_END, 10);
    }

    public QuerySubmit(Map<? extends String, ?> m) {
        super(m);
    }


    public int getLimitStart() {
        return Util.toInteger(super.get(LIMIT_START), 0);
    }

    public void setLimitStart(int start) {
        super.put(LIMIT_START, start);
    }

    public int getLimitEnd() {
        return Util.toInteger(super.get(LIMIT_END), 10);
    }

    public void setLimitEnd(int end) {
        super.put(LIMIT_END, end);
    }


    public void setLimit(final Integer page, final Integer pageSize) {
        int _page = 1;
        int _pageSize = 20;

        if (page != null && page.intValue() > 0) {
            _page = page.intValue();
        }

        if (pageSize != null && pageSize.intValue() > 0) {
            _pageSize = pageSize.intValue();
        }

        super.put(LIMIT_START, (_page - 1) * _pageSize);
        super.put(LIMIT_END, _pageSize);
    }

}
