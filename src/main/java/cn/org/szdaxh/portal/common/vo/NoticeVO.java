package cn.org.szdaxh.portal.common.vo;

import cn.org.szdaxh.portal.common.enums.NoticeTypeEnum;
import lombok.Data;

@Data
public class NoticeVO {
    private NoticeTypeEnum type;
    private String title;
    private String url;

    public NoticeVO() { }

    public NoticeVO(NoticeTypeEnum type, String title, String url) {
        this.type = type;
        this.title = title;
        this.url = url;
    }
}
