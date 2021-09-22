package cn.zengchen233.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")//抑制全部的警告提醒
public class IDUtils {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test() {
        System.out.println(IDUtils.getId());
    }
}
