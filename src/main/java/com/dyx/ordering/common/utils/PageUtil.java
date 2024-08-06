package com.dyx.ordering.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyx.ordering.common.entity.Query;

import java.util.Objects;

public class PageUtil {

    /**
     * 构造分页器
     * @param query
     * @return
     * @param <T>
     */
    public static <T> IPage<T> buildPage(Query query) {
        return
                new Page<>(
                        Objects.isNull(query.getCurrent()) ? 1 : query.getCurrent(),
                        Objects.isNull(query.getSize()) ? 10 : query.getSize()
                );
    }

}
