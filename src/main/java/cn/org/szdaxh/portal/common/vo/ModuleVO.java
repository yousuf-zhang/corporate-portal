package cn.org.szdaxh.portal.common.vo;

import cn.org.szdaxh.portal.common.entity.Module;
import cn.org.szdaxh.portal.common.enums.ModuleType;
import com.google.common.base.Converter;
import lombok.Data;
import org.springframework.beans.BeanUtils;

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
public class ModuleVO extends BaseConverter<ModuleVO, Module> {
    public static final String MODULE_SESSION_KEY = "navBars";
    public static final String BREADCRUMB_KEY = "breadcrumbs";
    public static final String SINGLE_BUTTON_KEY = "singleButton";
    public static final String BATCH_BUTTON_KEY = "batchButton";

    private static final long serialVersionUID = -327016587826009015L;
    private Long id;
    private Integer ordinal;
    private String name;
    private String url;
    private Long parentId;
    private ModuleType type;
    private String methodName;
    private List<ModuleVO> children;

    public ModuleVO() { }

    @Override
    protected Converter<ModuleVO, Module> convert() {
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
