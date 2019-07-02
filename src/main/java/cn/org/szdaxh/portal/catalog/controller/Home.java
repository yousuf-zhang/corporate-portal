package cn.org.szdaxh.portal.catalog.controller;

import cn.org.szdaxh.portal.common.BaseController;
import cn.org.szdaxh.portal.common.entity.Information;
import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;
import cn.org.szdaxh.portal.common.vo.InformationVO;
import cn.org.szdaxh.portal.common.vo.NoticeVO;
import cn.org.szdaxh.portal.common.vo.page.PageData;
import cn.org.szdaxh.portal.common.vo.page.PageRequest;
import cn.org.szdaxh.portal.service.InformationService;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Comparator;
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
public class Home extends BaseController {
    private final InformationService informationService;

    public Home(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String home(ModelMap map) {
        List<NoticeVO> noticeList = new ArrayList<>();
        noticeList.add(new NoticeVO(InfoTypeEnum.INFORMATION, "测试信息","http://test.com"));
        noticeList.add(new NoticeVO(InfoTypeEnum.INFORMATION, "测试信息123测试信息123测试信息123","http://test.com"));
        noticeList.add(new NoticeVO(InfoTypeEnum.INFORMATION, "测试信息测试信息123测试信息123测试信息123测试信息123测试信息123","http://test.com"));
        noticeList.add(new NoticeVO(InfoTypeEnum.INFORMATION, "测试信息","http://test.com"));
        noticeList.add(new NoticeVO(InfoTypeEnum.INFORMATION, "测试信息123测试信息123测试信息123","http://test.com"));
        noticeList.add(new NoticeVO(InfoTypeEnum.INFORMATION, "测试信息测试信息123测试信息123测试信息123测试信息123测试信息123","http://test.com"));
        map.put(InfoTypeEnum.INFORMATION.getCode(), noticeList);

        List<NoticeVO> carouselList = new ArrayList<>();
        carouselList.add(new NoticeVO(InfoTypeEnum.CAROUSEL,"深圳市档案培训深圳市档案培训深圳市档案培训", "carouse/Chrysanthemum.jpg"));
        carouselList.add(new NoticeVO(InfoTypeEnum.CAROUSEL,"测试测试测试测试测试测试测试测试", "carouse/Desert.jpg"));
        carouselList.add(new NoticeVO(InfoTypeEnum.CAROUSEL,"深圳市档案培训深圳市档案培训深圳市档案培训", "carouse/Hydrangeas.jpg"));
        map.put(InfoTypeEnum.CAROUSEL.getCode(), carouselList);
        return "/catalog/index";
    }

    @GetMapping("/announcement/list")
    @ResponseBody
    public PageData<Information> listAnnouncement(PageRequest request) {
        InformationVO informationVO = new InformationVO();
        informationVO.setType(InfoTypeEnum.ANNOUNCEMENT);
        return informationService.listInformationPages(request, informationVO);
    }

    @GetMapping("/announcement")
    public String findAnnouncement(Long id, ModelMap map) {
        InformationVO informationVO = informationService.findInformationById(id);
        map.put("announcement", informationVO);
        return "/catalog/announcement/detail";
    }

    @GetMapping("/information")
    public String findInformation(Long id, ModelMap map) {
        List<Information> informationList = informationService.listInformationByType(InfoTypeEnum.INFORMATION);
        informationList.sort(Comparator.comparing(Information::getOrdinal));
        Information information;
        if (id == null) {
            information = informationList.get(0);
        } else {
            InformationVO informationVO = informationService.findInformationById(id);
            information = informationVO.convertFor(informationVO);
        }
        map.put("information", information);
        map.put("informationList", informationList);
        return "/catalog/info/detail";
    }

}
