package cn.org.szdaxh.portal.admin.controller;

import cn.org.szdaxh.portal.common.BaseController;
import cn.org.szdaxh.portal.common.vo.ModuleVO;
import cn.org.szdaxh.portal.common.vo.UserSession;
import cn.org.szdaxh.portal.service.LoginService;
import cn.org.szdaxh.portal.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/admin")
public class LoginController extends BaseController {
    private final LoginService loginService;
    private final ModuleService moduleService;

    public LoginController(LoginService loginService, ModuleService moduleService) {
        this.loginService = loginService;
        this.moduleService = moduleService;
    }

    @GetMapping("/login")
    public String login() {
        return "/admin/login";
    }

    @PostMapping("/login")
    public String login(UserSession userSession, ModelMap modelMap) {
        UserSession session = loginService.loginVerify(userSession);
        if (session == null) {
            return "redirect:/admin/login";
        }
        getSession().setAttribute(UserSession.USER_SESSION_KEY, session);
        getSession().setAttribute(ModuleVO.MODULE_SESSION_KEY, moduleService.findNavBars(session.getModules()));
       // modelMap.put(ModuleVO.BREADCRUMB_KEY, moduleService.findModuleBreadcrumb("admin/index", session.getModules
        // ()));
        return "redirect:/admin/index";
    }

    @GetMapping("/logout")
    public String logout() {
        getSession().removeAttribute(UserSession.USER_SESSION_KEY);
        return "redirect:/admin/login";
    }
}
