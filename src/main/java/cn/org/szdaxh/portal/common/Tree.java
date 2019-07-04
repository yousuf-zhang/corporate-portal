package cn.org.szdaxh.portal.common;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

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
public class Tree {
    public static void findTree(TreeTest root, List<TreeTest> tests) {
        tests.stream()
                .filter(treeTest -> Objects.equals(root.getId(), treeTest.getPid()))
                .forEach(treeTest -> {
                    List<TreeTest> children = Lists.newArrayList();
                    children.add(treeTest);
                    findTree(treeTest, tests);
                    root.setChildren(children);
                });
    }

    public static void main(String[] args) {
        List<TreeTest> test = Lists.newArrayList(
                TreeTest.builder().id(1L).pid(0L).build(),
                TreeTest.builder().id(2L).pid(1L).build(),
                TreeTest.builder().id(3L).pid(1L).build(),
                TreeTest.builder().id(4L).pid(2L).build(),
                TreeTest.builder().id(5L).pid(2L).build(),
                TreeTest.builder().id(6L).pid(5L).build(),
                TreeTest.builder().id(7L).pid(5L).build(),
                TreeTest.builder().id(8L).pid(7L).build(),
                TreeTest.builder().id(9L).pid(8L).build(),
                TreeTest.builder().id(10L).pid(8L).build()
        );
        TreeTest root = TreeTest.builder().id(1L).pid(0L).build();
        findTree(root, test);
        System.out.println(root);
    }
}
