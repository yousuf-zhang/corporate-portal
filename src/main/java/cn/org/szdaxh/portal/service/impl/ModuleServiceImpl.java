package cn.org.szdaxh.portal.service.impl;

import cn.org.szdaxh.portal.repo.ModuleRepo;
import cn.org.szdaxh.portal.service.ModuleService;
import cn.org.szdaxh.portal.common.entity.Module;
import cn.org.szdaxh.portal.common.vo.ModuleVO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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
@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepo moduleRepo;

    public ModuleServiceImpl(ModuleRepo moduleRepo) {
        this.moduleRepo = moduleRepo;
    }

    @Override
    public Module save(Module module) {
        return moduleRepo.save(module);
    }

    @Override
    public void delete(Module module) {
        moduleRepo.delete(module);
    }

    @Override
    public List<ModuleVO> findModuleVOS() {
        List<Module> modules = moduleRepo.findAll();
        List<ModuleVO> navBars = Lists.newArrayList();
        findParentModuleVO(modules, navBars);
        if (navBars.size() > 0) {
            navBars.get(0).setExpanded(true);
        }
        return navBars;
    }

    @Override
    public List<ModuleVO> findModuleBreadcrumb(String url) {
        List<Module> modules = moduleRepo.findAll();
        List<ModuleVO> moduleVOS = Lists.newArrayList();
        ModuleVO moduleVO = findModuleVO(url, modules);
        moduleVOS.add(moduleVO);
        findModuleVO(moduleVO, modules, moduleVOS);
        Collections.reverse(moduleVOS);
        return moduleVOS;
    }

    private void findModuleVO(ModuleVO moduleVO, List<Module> modules, List<ModuleVO> moduleVOS) {
        if (!Objects.equals(moduleVO.getParentId(), 0L)) {
            ModuleVO vo = new ModuleVO().convertBack(modules.stream()
                    .filter(module -> Objects.equals(module.getId(), moduleVO.getParentId()))
                    .findFirst().orElseThrow(() -> new RuntimeException("获取模块异常")));
            moduleVOS.add(vo);
            findModuleVO(vo, modules, moduleVOS);
        }
    }

    private ModuleVO findModuleVO(String url, List<Module> modules) {
        return new ModuleVO()
                .convertBack(modules.stream()
                .filter(module -> Objects.equals(url, module.getUrl()))
                .findFirst()
                .orElse(modules.stream()
                .filter(module -> module.getParentId().equals(0L))
                .min(Comparator.comparing(Module::getOrdinal))
                .orElseThrow(() -> new RuntimeException("获取模块失败"))));
    }

    private void findParentModuleVO(List<Module> modules, List<ModuleVO> navBars) {
        modules.stream()
        .filter(module -> Objects.equals(module.getParentId(), 0L))
        .sorted(Comparator.comparing(Module::getOrdinal))
        .forEach(module -> findChildrenModuleVO(modules, navBars, module));
    }

    private void findChildrenModuleVO(List<Module> modules, List<ModuleVO> navBars, Module module) {
        ModuleVO parentVO = new ModuleVO().convertBack(module);
        List<ModuleVO> childrenVO = Lists.newArrayList();
        modules.stream()
            .filter(child -> Objects.equals(child.getParentId(), module.getId()))
            .sorted(Comparator.comparing(Module::getOrdinal))
            .forEach(child -> {
                ModuleVO childVO = new ModuleVO().convertBack(child);
                childrenVO.add(childVO);
            });
        parentVO.setChildren(childrenVO);
        navBars.add(parentVO);
    }
}
