package cn.org.szdaxh.portal.config;

import cn.org.szdaxh.portal.common.enums.ModuleType;
import cn.org.szdaxh.portal.common.vo.ModuleVO;
import cn.org.szdaxh.portal.common.vo.UserSession;
import cn.org.szdaxh.portal.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURI().substring(1);
        UserSession userSession = (UserSession) request.getSession().getAttribute(UserSession.USER_SESSION_KEY);
        if (userSession != null && !url.equals("admin/ueditor/config")) {
            List<ModuleVO> breadcrumb = moduleService.findModuleBreadcrumb(url, userSession.getModules());
            List<ModuleVO> singleButtons = moduleService.findButtons(url, userSession.getModules(), ModuleType.SINGLE_BUTTON);
            List<ModuleVO> batchButtons = moduleService.findButtons(url, userSession.getModules(), ModuleType.BATCH_BUTTON);
            modelAndView.getModelMap().put(ModuleVO.BREADCRUMB_KEY, breadcrumb);
            modelAndView.getModelMap().put(ModuleVO.SINGLE_BUTTON_KEY, singleButtons);
            modelAndView.getModelMap().put(ModuleVO.BATCH_BUTTON_KEY, batchButtons);
        }
    }
}
