package cn.org.szdaxh.portal.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/13
 */
@Data
public class UserSession implements Serializable {
    public static final String USER_SESSION_KEY="portal_admin_session";
    private static final long serialVersionUID = -6018956502823031454L;

    private String userName;
    private String password;
}
