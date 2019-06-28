package cn.org.szdaxh.portal.common.enums;

public enum InfoTypeEnum implements BaseEnum<String> {
    /**公告类型*/
    ANNOUNCEMENT("announcement", "通知公告"),
    INFORMATION("information", "信息公开"),
    CAROUSEL("carousel", "滚动公告"),

    ;

    private String code;
    private String text;

    InfoTypeEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
