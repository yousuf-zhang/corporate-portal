package cn.org.szdaxh.portal.common.vo;

import cn.org.szdaxh.portal.common.entity.Information;
import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;
import com.google.common.base.Converter;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/21
 */
@Data
public class InformationVO extends BaseConverter<InformationVO, Information>{
    private static final long serialVersionUID = 474703997798081838L;
    private Long id;
    private InfoTypeEnum type;
    private String title;
    private String content;
    protected LocalDateTime createAt;
    protected LocalDateTime modifyAt;

    @Override
    protected Converter<InformationVO, Information> convert() {
        return Converter.from(announcement -> {
            if (announcement == null) {
                return null;
            }
            Information information = new Information();
            BeanUtils.copyProperties(announcement, information);
            return information;
        }, information -> {
            if (information == null) {
                return null;
            }
            InformationVO informationVO = new InformationVO();
            BeanUtils.copyProperties(information, informationVO);
            return informationVO;
        });
    }

}
