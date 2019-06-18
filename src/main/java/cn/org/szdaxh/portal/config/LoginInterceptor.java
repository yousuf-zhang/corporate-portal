package cn.org.szdaxh.portal.config;

import cn.org.szdaxh.portal.common.vo.ModuleVO;
import cn.org.szdaxh.portal.common.vo.UserSession;
import cn.org.szdaxh.portal.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ModuleService moduleService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserSession userSession = (UserSession) request.getSession().getAttribute(UserSession.USER_SESSION_KEY);
        if (userSession == null) {
            response.sendRedirect("/admin/login");
            return false;
        }
        String url = request.getRequestURI().substring(1);
        if (!url.equals("admin/ueditor/config")) {
            List<ModuleVO> breadcrumb = moduleService.findModuleBreadcrumb(url);
            request.getSession().setAttribute(ModuleVO.BREADCRUMB_SESSION_KEY, breadcrumb);
        }

        return true;
    }
}
