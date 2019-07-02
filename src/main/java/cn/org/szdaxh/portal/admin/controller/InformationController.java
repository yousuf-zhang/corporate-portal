package cn.org.szdaxh.portal.admin.controller;

import cn.org.szdaxh.portal.common.BaseController;
import cn.org.szdaxh.portal.common.entity.Information;
import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;
import cn.org.szdaxh.portal.common.vo.InformationVO;
import cn.org.szdaxh.portal.common.vo.MessageVO;
import cn.org.szdaxh.portal.common.vo.page.PageData;
import cn.org.szdaxh.portal.common.vo.page.PageRequest;
import cn.org.szdaxh.portal.service.InformationService;
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
@RequestMapping("/admin/info")
public class InformationController extends BaseController {
    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/list")
    public String listInfo(PageRequest pageRequest , ModelMap modelMap) {
        InformationVO informationVO = new InformationVO();
        pageRequest.setSorts("ordinal");
        pageRequest.setDirection("asc");
        informationVO.setType(InfoTypeEnum.INFORMATION);
        PageData<Information> pages = informationService.listInformationPages(pageRequest, informationVO);
        modelMap.put(PAGE_DATA, pages);
        return "/admin/info/info-list";
    }

    @GetMapping("/add")
    public String addInformation() {
        return "/admin/info/add";
    }

    @PostMapping("/add")
    public String saveInformation(InformationVO informationVO, ModelMap map) {
        informationVO.setType(InfoTypeEnum.INFORMATION);
        informationService.saveInformation(informationVO);
        return MessageVO.builder()
                .content("添加信息成功")
                .url("/admin/info/list")
                .type(MessageVO.MessageType.SUCCESS)
                .build()
                .addModelMap(map)
                .view();
    }

    @GetMapping("/update")
    public String updateAnnouncement(Long id, ModelMap map) {
        InformationVO vo = informationService.findInformationById(id);
        map.put("information", vo);
        return "/admin/info/update";
    }

    @PostMapping("/update")
    public String updateAnnouncement(InformationVO informationVO, ModelMap map) {
        informationService.updateInformation(informationVO);
        return MessageVO.builder()
                .content("修改信息成功")
                .url("admin/info/list")
                .type(MessageVO.MessageType.SUCCESS)
                .build()
                .addModelMap(map)
                .view();
    }

    @GetMapping("/delete")
    public String deleteAnnouncement(Long id, ModelMap map) {
        informationService.deleteInformationById(id);
        return MessageVO.builder()
                .content("删除信息成功")
                .url("admin/info/list")
                .type(MessageVO.MessageType.SUCCESS)
                .build()
                .addModelMap(map)
                .view();
    }
}
