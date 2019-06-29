package cn.org.szdaxh.portal.service;

public class Test {

    @org.junit.Test
    public void test() {
        String aa = "https://aa/bb";
        String bb = "https://aa";
        System.out.println(bb.contains(aa));
        System.out.println(aa.contains(bb));
    }
}
