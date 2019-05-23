package cn.org.szdaxh.portal.catalog.controller;

import cn.org.szdaxh.portal.common.enums.NoticeTypeEnum;
import cn.org.szdaxh.portal.common.vo.NoticeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String home(ModelMap map) {
        List<NoticeVO> noticeList = new ArrayList<>();
        noticeList.add(new NoticeVO(NoticeTypeEnum.INFORMATION, "测试信息","http://test.com"));
        noticeList.add(new NoticeVO(NoticeTypeEnum.INFORMATION, "测试信息123测试信息123测试信息123","http://test.com"));
        noticeList.add(new NoticeVO(NoticeTypeEnum.INFORMATION, "测试信息测试信息123测试信息123测试信息123测试信息123测试信息123","http://test.com"));
        noticeList.add(new NoticeVO(NoticeTypeEnum.INFORMATION, "测试信息","http://test.com"));
        noticeList.add(new NoticeVO(NoticeTypeEnum.INFORMATION, "测试信息123测试信息123测试信息123","http://test.com"));
        noticeList.add(new NoticeVO(NoticeTypeEnum.INFORMATION, "测试信息测试信息123测试信息123测试信息123测试信息123测试信息123","http://test.com"));
        map.put(NoticeTypeEnum.INFORMATION.getCode(), noticeList);

        List<NoticeVO> carouselList = new ArrayList<>();
        carouselList.add(new NoticeVO(NoticeTypeEnum.CAROUSEL,"深圳市档案培训深圳市档案培训深圳市档案培训", "carouse/Chrysanthemum.jpg"));
        carouselList.add(new NoticeVO(NoticeTypeEnum.CAROUSEL,"测试测试测试测试测试测试测试测试", "carouse/Desert.jpg"));
        carouselList.add(new NoticeVO(NoticeTypeEnum.CAROUSEL,"深圳市档案培训深圳市档案培训深圳市档案培训", "carouse/Hydrangeas.jpg"));
        map.put(NoticeTypeEnum.CAROUSEL.getCode(), carouselList);
        return "/catalog/index";
    }

    @GetMapping("/test")
    public String test() {return "/catalog/test/test";}

}
