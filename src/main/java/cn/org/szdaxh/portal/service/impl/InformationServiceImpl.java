package cn.org.szdaxh.portal.service.impl;

import cn.org.szdaxh.portal.common.entity.Information;
import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;
import cn.org.szdaxh.portal.common.vo.InformationVO;
import cn.org.szdaxh.portal.common.vo.page.PageData;
import cn.org.szdaxh.portal.common.vo.page.PageRequest;
import cn.org.szdaxh.portal.repo.InformationRepo;
import cn.org.szdaxh.portal.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public PageData<Information> listInformationPages(PageRequest pageRequest, InformationVO informationVO) {

        Information information = new Information();
        if (informationVO.getType() != null) {
            information.setType(informationVO.getType());
        }
        Example<Information> example = Example.of(information);
        Page<Information> pages = informationRepo.findAll(example, PageRequest.valueOf(pageRequest));
        return PageData.of(pages, pageRequest);
    }

    @Override
    public InformationVO findInformationById(Long id) {
        return new InformationVO().convertBack(informationRepo.findById(id).orElse(null));
    }

    @Override
    public void updateInformation(InformationVO informationVO) {
        Information information = informationRepo.getOne(informationVO.getId());
        information.setContent(informationVO.getContent());
        information.setTitle(informationVO.getTitle());
        information.setOrdinal(informationVO.getOrdinal());
        informationRepo.save(information);
    }

    @Override
    public void deleteInformationById(Long id) {
        informationRepo.deleteById(id);
    }

    @Override
    public List<Information> listInformationByType(InfoTypeEnum type) {
        return informationRepo.findAllByType(type);
    }
}
