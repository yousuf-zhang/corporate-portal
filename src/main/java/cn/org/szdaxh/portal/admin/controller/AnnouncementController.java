package cn.org.szdaxh.portal.admin.controller;

import cn.org.szdaxh.portal.common.BaseController;
import cn.org.szdaxh.portal.common.entity.Information;
import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;
import cn.org.szdaxh.portal.common.vo.InformationVO;
import cn.org.szdaxh.portal.common.vo.MessageVO;
import cn.org.szdaxh.portal.common.vo.page.PageData;
import cn.org.szdaxh.portal.common.vo.page.PageRequest;
import cn.org.szdaxh.portal.service.InformationService;
import lombok.extern.slf4j.Slf4j;
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
 * @Datetime 2019/6/20
 */
@Slf4j
@Controller
@RequestMapping("/admin/announcement")
public class AnnouncementController extends BaseController {
    private final InformationService informationService;

    public AnnouncementController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/list")
    public String listAnnouncement(PageRequest pageRequest, ModelMap modelMap) {
        pageRequest.setSize(2);
        PageData<Information> pages = informationService.listInformationPages(pageRequest);
        log.info(pages.toString());
        modelMap.put(PAGE_DATA, pages);
        return "/admin/announcement/list";
    }
    @GetMapping("/add")
    public String addAnnouncement() {

        return "/admin/announcement/add";
    }

    @PostMapping("/add")
    public String addAnnouncement (InformationVO informationVO, ModelMap map) {
        informationVO.setType(InfoTypeEnum.INFORMATION);
        informationService.saveInformation(informationVO);
        return MessageVO.builder()
                .content("新增公告成功")
                .url("admin/announcement/list")
                .type(MessageVO.MessageType.SUCCESS)
                .build()
                .addModelMap(map)
                .view();
    }
}
