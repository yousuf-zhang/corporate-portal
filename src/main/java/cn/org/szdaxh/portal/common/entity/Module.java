package cn.org.szdaxh.portal.common.entity;

import cn.org.szdaxh.portal.common.enums.ModuleType;
import lombok.Data;
import sun.security.pkcs11.Secmod;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity
@Table(name = "xh_admin_module")
public class Module extends BaseEntity {
    private static final long serialVersionUID = 5379112984668774429L;
    private Integer ordinal;
    private String name;
    private String url;
    private Long parentId;
    private ModuleType type;
    private String methodName;

    public Module() { }


    public Module(Integer ordinal, String name, String url, Long parentId) {
        this.ordinal = ordinal;
        this.name = name;
        this.url = url;
        this.parentId = parentId;
    }
}
