package cn.org.szdaxh.portal.service;

import cn.org.szdaxh.portal.common.vo.UserSession;

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
public interface LoginService {
    UserSession loginVerify(UserSession userSession);
}
