package cn.org.szdaxh.portal.config;

import cn.org.szdaxh.portal.common.vo.ModuleVO;
import cn.org.szdaxh.portal.common.vo.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserSession userSession = (UserSession) request.getSession().getAttribute(UserSession.USER_SESSION_KEY);
        if (userSession == null) {
            response.sendRedirect("/admin/login");
            return false;
        }
        @SuppressWarnings("unchecked")
        List<ModuleVO> moduleVOS = (List<ModuleVO>) request.getSession().getAttribute(ModuleVO.MODULE_SESSION_KEY);
        String url = request.getRequestURI();
        moduleVOS.forEach(moduleVO -> {
            moduleVO.setExpanded(false);
            moduleVO.getChildren()
                    .stream()
                    .map(ModuleVO::getUrl)
                    .filter(url::contains)
                    .findFirst()
                    .ifPresent(s -> moduleVO.setExpanded(true));
        });
        return true;
    }
}
