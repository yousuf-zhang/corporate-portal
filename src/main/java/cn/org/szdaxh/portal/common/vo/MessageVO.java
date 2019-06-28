package cn.org.szdaxh.portal.common.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.awt.*;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/27
 */
@Data
@Builder
public class MessageVO {
    private String content;
    private String url;
    private String viewUrl;
    private MessageType type;


    @Getter
    public enum MessageType {
        /***/
        SUCCESS("admin/success"), ERROR(""), INFO("");
        private String viewUrl;

        MessageType(String viewUrl) {
            this.viewUrl = viewUrl;
        }
    }

    public MessageVO addModelMap(ModelMap map) {
        map.put("content", this.content);
        map.put("url", this.url);
        return this;
    }

    public String view() {
        return  this.getViewUrl() == null ? this.getType().getViewUrl() : this.getViewUrl();
    }
}
