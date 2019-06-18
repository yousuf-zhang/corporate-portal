package cn.org.szdaxh.portal.common.vo;

import cn.org.szdaxh.portal.common.entity.Module;
import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
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
@Data
public class ModuleVO implements Serializable {
    public static final String MODULE_SESSION_KEY = "navBars";
    public static final String BREADCRUMB_SESSION_KEY = "breadcrumbs";
    private static final long serialVersionUID = -327016587826009015L;
    private Long id;
    private Integer ordinal;
    private String name;
    private String url;
    private Long parentId;
    private Boolean expanded;
    private List<ModuleVO> children;

    public ModuleVO() {
        this.expanded = Boolean.FALSE;
    }

    public ModuleVO convertBack(Module module) {
        return convert().reverse().convert(module);
    }

    public Module convertFor(ModuleVO moduleVO) {
       return convert().convert(moduleVO);
    }

    private Converter<ModuleVO, Module> convert() {
        return Converter.from(moduleVO -> {
            if (moduleVO == null) {
                return null;
            }
            Module module = new Module();
            BeanUtils.copyProperties(moduleVO, module);
            return module;
        }, module -> {
            if (module == null) {
                return null;
            }
            ModuleVO moduleVO = new ModuleVO();
            BeanUtils.copyProperties(module, moduleVO);
            return moduleVO;
        });
    }
}
