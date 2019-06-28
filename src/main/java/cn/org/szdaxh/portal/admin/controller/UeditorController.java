package cn.org.szdaxh.portal.admin.controller;

import cn.org.szdaxh.portal.common.BaseController;
import cn.org.szdaxh.portal.ueditor.ActionEnter;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/14
 */
@RestController
@RequestMapping("/admin/ueditor")
public class UeditorController extends BaseController {

    @RequestMapping("/config")
    public String ueditorConfig(HttpServletRequest request) throws JSONException {
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        return new ActionEnter(request, rootPath).exec();

    }
}
