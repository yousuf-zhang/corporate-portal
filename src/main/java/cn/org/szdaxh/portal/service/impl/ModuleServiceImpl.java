package cn.org.szdaxh.portal.service.impl;

import cn.org.szdaxh.portal.common.enums.ModuleType;
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
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

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
        List<ModuleVO> moduleVOS = Lists.newArrayList();
        modules.forEach(module -> moduleVOS.add(new ModuleVO().convertBack(module)));
        return moduleVOS;
    }

    @Override
    public List<ModuleVO> findNavBars(List<ModuleVO> modules) {
        List<ModuleVO> navBars = Lists.newArrayList();
        findParentModuleVO(modules, navBars);
        return navBars;
    }

    @Override
    public List<ModuleVO> findModuleBreadcrumb(String url, List<ModuleVO> modules) {
        List<ModuleVO> moduleVOS = Lists.newArrayList();
        ModuleVO moduleVO = findModuleVO(url, modules);
        moduleVOS.add(moduleVO);
        findModuleVO(moduleVO, modules, moduleVOS);
        Collections.reverse(moduleVOS);
        return moduleVOS;
    }

    @Override
    public List<ModuleVO> findButtons(String url, List<ModuleVO> modules, ModuleType moduleType) {
        ModuleVO parent = findModuleVO(url, modules);
        return modules.stream()
                .filter(moduleVO -> Objects.equals(moduleVO.getParentId(), parent.getId()))
                .filter(moduleVO -> moduleVO.getType() == moduleType)
                .sorted(Comparator.comparing(ModuleVO::getOrdinal))
                .collect(Collectors.toList());
    }

    private void findModuleVO(ModuleVO moduleVO, List<ModuleVO> modules, List<ModuleVO> moduleVOS) {
        if (!Objects.equals(moduleVO.getParentId(), 0L)) {
            ModuleVO vo =modules.stream()
                    .filter(module -> Objects.equals(module.getId(), moduleVO.getParentId()))
                    .findFirst().orElseThrow(() -> new RuntimeException("获取模块异常"));
            moduleVOS.add(vo);
            findModuleVO(vo, modules, moduleVOS);
        }
    }




    private ModuleVO findModuleVO(String url, List<ModuleVO> modules) {
        Module index = new Module(1,"首页", "", 0L);
        index.setId(-100L);
        return modules.stream()
                .filter(module -> Objects.equals(url, module.getUrl()))
                .findFirst()
                .orElse(new ModuleVO().convertBack(index));
    }

    private void findParentModuleVO(List<ModuleVO> modules, List<ModuleVO> navBars) {
        modules.stream()
        .filter(module -> Objects.equals(module.getParentId(), 0L))
        .sorted(Comparator.comparing(ModuleVO::getOrdinal))
        .forEach(module -> findChildrenModuleVO(modules, navBars, module));
    }

    private void findChildrenModuleVO(List<ModuleVO> modules, List<ModuleVO> navBars, ModuleVO parent) {
        List<ModuleVO> childrenVO = Lists.newArrayList();
        modules.stream()
            .filter(child -> Objects.equals(child.getParentId(), parent.getId()))
            .sorted(Comparator.comparing(ModuleVO::getOrdinal))
            .forEach(childrenVO::add);
        parent.setChildren(childrenVO);
        navBars.add(parent);
    }
}
