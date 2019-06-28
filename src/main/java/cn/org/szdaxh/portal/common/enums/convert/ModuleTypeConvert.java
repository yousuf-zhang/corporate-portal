package cn.org.szdaxh.portal.common.enums.convert;

import cn.org.szdaxh.portal.common.enums.BaseEnum;
import cn.org.szdaxh.portal.common.enums.ModuleType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/20
 */
@Converter(autoApply = true)
public class ModuleTypeConvert implements AttributeConverter<ModuleType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ModuleType attribute) {
        return attribute.getCode();
    }

    @Override
    public ModuleType convertToEntityAttribute(Integer dbData) {
        return BaseEnum.findByCode(ModuleType.class, dbData).orElse(null);
    }
}
