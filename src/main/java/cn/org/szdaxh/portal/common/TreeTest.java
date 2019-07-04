package cn.org.szdaxh.portal.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/7/4
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeTest {
    Long id;
    Long pid;
    List<TreeTest> children;
}
