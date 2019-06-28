package cn.org.szdaxh.portal.common.enums.convert;

import cn.org.szdaxh.portal.common.enums.BaseEnum;
import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;

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
 * @Datetime 2019/6/26
 */
@Converter(autoApply = true)
public class InfoTypeConvert implements AttributeConverter<InfoTypeEnum, String> {
    @Override
    public String convertToDatabaseColumn(InfoTypeEnum attribute) {
        return attribute.getCode();
    }

    @Override
    public InfoTypeEnum convertToEntityAttribute(String dbData) {
        return BaseEnum.findByCode(InfoTypeEnum.class, dbData).orElse(null);
    }
}
