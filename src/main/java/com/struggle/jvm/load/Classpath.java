package com.struggle.jvm.load;

import com.struggle.jvm.entry.Entry;

/**
 * @author strugglesnail
 * @date 2021/4/14
 * @desc 类路径加载
 */
public class Classpath {

    private Entry bootstrapClasspath; //启动类路径
    private Entry extensionClasspath; //扩展类路径
    private Entry userClasspath; //用户类路径

    public Classpath(String jreOption, String userOption) {
        // 启动类&扩展类 "C:\Program Files\Java\jdk1.8.0_161\jre"

        // 用户类：程序员自定义的类

    }

    // 启动类和扩展类路径
    private void bootstrapAndExtensionClasspath(String jreOption) {
        // 获取jre目录

        // 获取jre/lib路径

        // 创建启动类路径

        // 获取jre/lib/ext路径

        // 创建扩展类路径

    }

    // 获取jre目录
    private static String getJreDir(String jreOption) {
        return null;
    }

    // 解析用户类路径

    // 读取类文件获取字节码
    private byte[] readClass(String className) {
        return null;
    }

}
