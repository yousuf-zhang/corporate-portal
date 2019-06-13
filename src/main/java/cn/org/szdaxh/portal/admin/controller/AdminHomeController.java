package cn.org.szdaxh.portal.admin.controller;

import cn.org.szdaxh.portal.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title: 首页 </p>
 * <p>Description: 首页 </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 *
 * @author zhangshuai
 * @version V3.0
 * @date 2019/1/29 15:26
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController extends BaseController {

    @GetMapping(value = {"","/"})
    public String index() {
        return "redirect:/admin/index";
    }

    @GetMapping("/index")
    public String home() {

        return "/admin/index";
    }

}
