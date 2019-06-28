package cn.org.szdaxh.portal.common.vo;

import com.google.common.base.Converter;

import java.io.Serializable;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/26
 */
public abstract class BaseConverter<T, R> implements Serializable {

    private static final long serialVersionUID = 8984994259944599667L;

    protected abstract Converter<T, R> convert();

    public R convertFor (T t) {
        return convert().convert(t);
    }

    public T convertBack(R r) {
        return convert().reverse().convert(r);
    }

}
