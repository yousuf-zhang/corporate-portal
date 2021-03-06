package cn.org.szdaxh.portal.service;

import cn.org.szdaxh.portal.common.entity.Information;
import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;
import cn.org.szdaxh.portal.common.vo.InformationVO;
import cn.org.szdaxh.portal.common.vo.page.PageData;
import cn.org.szdaxh.portal.common.vo.page.PageRequest;

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
public interface InformationService {
    void saveInformation(InformationVO informationVO);

    PageData<Information> listInformationPages(PageRequest pageRequest, InformationVO informationVO);

    InformationVO findInformationById(Long id);

    void updateInformation(InformationVO announcement);

    void deleteInformationById(Long id);

    List<Information> listInformationByType(InfoTypeEnum information);
}
