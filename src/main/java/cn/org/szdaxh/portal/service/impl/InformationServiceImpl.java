package cn.org.szdaxh.portal.service.impl;

import cn.org.szdaxh.portal.common.entity.Information;
import cn.org.szdaxh.portal.common.vo.InformationVO;
import cn.org.szdaxh.portal.common.vo.page.PageData;
import cn.org.szdaxh.portal.common.vo.page.PageRequest;
import cn.org.szdaxh.portal.repo.InformationRepo;
import cn.org.szdaxh.portal.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/27
 */
@Slf4j
@Service
public class InformationServiceImpl implements InformationService {
    private final InformationRepo informationRepo;

    public InformationServiceImpl(InformationRepo informationRepo) {
        this.informationRepo = informationRepo;
    }

    @Override
    public void saveInformation(InformationVO informationVO) {
        this.informationRepo.save(informationVO.convertFor(informationVO));
    }

    @Override
    public PageData<Information> listInformationPages(PageRequest pageRequest) {
        pageRequest.setSorts("modifyAt");
        Page<Information> pages = informationRepo.findAll(PageRequest.valueOf(pageRequest));
        return PageData.of(pages, pageRequest);
    }

    @Override
    public InformationVO findAnnouncementById(Long id) {
        return new InformationVO().convertBack(informationRepo.findById(id).orElse(null));
    }

    @Override
    public void updateInformation(InformationVO announcement) {
        Information information = informationRepo.getOne(announcement.getId());
        information.setContent(announcement.getContent());
        information.setTitle(announcement.getTitle());
        informationRepo.save(information);
    }

    @Override
    public void deleteAnnouncement(Long id) {
        informationRepo.deleteById(id);
    }
}
