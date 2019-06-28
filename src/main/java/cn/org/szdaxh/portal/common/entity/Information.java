package cn.org.szdaxh.portal.common.entity;

import cn.org.szdaxh.portal.common.enums.InfoTypeEnum;
import lombok.Data;

import javax.persistence.*;

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
@Data
@Entity
@Table(name = "xh_information")
public class Information extends BaseEntity {
    private static final long serialVersionUID = -2813006351995591958L;
    private String title;
    private InfoTypeEnum type;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false, columnDefinition = "Text")
    private String content;

}
