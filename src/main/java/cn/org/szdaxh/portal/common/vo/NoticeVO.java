package cn.org.szdaxh.portal.common.vo;

import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;
import lombok.Data;

@Data
public class NoticeVO {
    private InfoTypeEnum type;
    private String title;
    private String url;

    public NoticeVO() { }

    public NoticeVO(InfoTypeEnum type, String title, String url) {
        this.type = type;
        this.title = title;
        this.url = url;
    }
}
