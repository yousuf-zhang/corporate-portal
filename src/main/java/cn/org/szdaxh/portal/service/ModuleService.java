package cn.org.szdaxh.portal.service;

import cn.org.szdaxh.portal.common.entity.Module;
import cn.org.szdaxh.portal.common.vo.ModuleVO;

import java.util.List;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/11
 */
public interface ModuleService {
    Module save(Module module);
    void delete(Module module);

    List<ModuleVO> findModuleVOS();

    List<ModuleVO> findModuleBreadcrumb(String url);
}
