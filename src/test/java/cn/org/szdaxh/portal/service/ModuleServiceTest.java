package cn.org.szdaxh.portal.service;

import cn.org.szdaxh.portal.common.entity.Module;
import cn.org.szdaxh.portal.common.vo.ModuleVO;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleServiceTest {
    @Autowired
    private ModuleService moduleService;

    @Test
    public void should_return_module_by_save() {
        Module module = new Module();
        module.setName("系统管理111");
        module.setOrdinal(1);
        module.setParentId(0L);
        Module save = moduleService.save(module);
        assertThat(save.getId() != null, is(true));
        moduleService.delete(save);
//        init();
    }

    @Test
    public void should_return_navBars() {
        List<ModuleVO> moduleVOS = moduleService.findModuleVOS();
        assertThat(moduleVOS.size(), is(2));
        assertThat(moduleVOS.get(0).getName(), is("系统管理"));
        assertThat(moduleVOS.get(1).getName(), is("信息公开"));
        assertThat(moduleVOS.get(1).getChildren().get(0).getName(), is("信息列表"));
    }

    private void init() {
        Module module = new Module(2, "信息公开", "", 0L);
        Module save = moduleService.save(module);
        Lists.newArrayList(new Module(1, "信息列表", "admin/info/list", save.getId()),
                new Module(2, "信息动态", "admin/info/dynamic", save.getId()))
                .forEach(module1 -> moduleService.save(module1));
    }
}