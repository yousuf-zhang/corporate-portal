package cn.org.szdaxh.portal.repo;

import cn.org.szdaxh.portal.common.entity.Information;
import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;

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
public interface InformationRepo extends BaseRepo<Information, Long> {
    List<Information> findAllByType(InfoTypeEnum type);
}
