package cn.org.szdaxh.portal.service.impl;

import cn.org.szdaxh.portal.common.vo.UserSession;
import cn.org.szdaxh.portal.service.LoginService;
import org.springframework.stereotype.Service;

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
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public UserSession loginVerify(UserSession userSession) {
        UserSession session = new UserSession();
        return session;
    }
}
