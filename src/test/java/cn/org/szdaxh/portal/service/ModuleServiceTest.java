package cn.org.szdaxh.portal.service;

import cn.org.szdaxh.portal.common.entity.Module;
import cn.org.szdaxh.portal.common.enums.ModuleType;
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
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ModuleServiceTest {
    @Autowired
    private ModuleService moduleService;

    @Test
    public void should_return_module_by_save() {
        Module module = new Module(1, "新增公告", "/admin/announcement/add", 18L);
        module.setType(ModuleType.BATCH_BUTTON);
        Module save = moduleService.save(module);
        assertThat(save.getId() != null, is(true));
//        moduleService.delete(save);
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

    @Test
    public void test_card_type() {
        int type = 0x0000;
        int master = type | 0x0001;
        int visa = type | 0x0002;
        int am = type | 0x0004;
        int all = 0x0001 | 0x0002 | 0x0004 | 0x0008 | 0x0010 | 0x0020 | 0x0040 | 0x0080;
        System.out.println(visa & 0x0002);
        System.out.println(master & 0x0001);
        System.out.println(am & 0x0004);
    }

    private void init() {
        Module module = new Module(3, "通知公告", "", 0L);
        Module save = moduleService.save(module);
//        Lists.newArrayList(new Module(1, "公告列表", "admin/info/list", save.getId()),
//                new Module(2, "信息动态", "admin/info/dynamic", save.getId()))
//                .forEach(module1 -> moduleService.save(module1));

        Lists.newArrayList(new Module(1, "公告列表", "/admin/announcement/list", save.getId()))
                .forEach(module1 -> moduleService.save(module1));
    }
}