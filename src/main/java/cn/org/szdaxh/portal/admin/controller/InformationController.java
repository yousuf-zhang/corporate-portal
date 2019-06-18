package cn.org.szdaxh.portal.admin.controller;

import cn.org.szdaxh.portal.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/admin/info")
public class InformationController extends BaseController {

    @GetMapping("/list")
    public String listInfo() {

        return "/admin/info/info_list";
    }
}
