package cn.org.szdaxh.portal.common.enums;

import lombok.Getter;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/20
 */
public enum ModuleType implements BaseEnum<Integer> {
    /***/
    MODULE(1,"模块"),
    SINGLE_BUTTON(2, "单条操作"),
    BATCH_BUTTON(3, "批量操作");

    ModuleType(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    private Integer code;
    private String text;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
