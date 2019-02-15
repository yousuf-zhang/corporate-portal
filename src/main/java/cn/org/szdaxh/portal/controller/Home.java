package cn.org.szdaxh.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
public class Home {

    @GetMapping("/")
    public String index() {
        return "/catalog/index";
    }

    @GetMapping("/test")
    public String test() {return "/catalog/test/test";}

}
