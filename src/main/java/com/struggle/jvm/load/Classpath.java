package com.struggle.jvm.load;

import com.struggle.jvm.load.classpath.Entry;
import com.struggle.jvm.load.classpath.WildcardEntry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        bootstrapAndExtensionClasspath(jreOption);
        // 用户类：程序员自定义的类
        parseUserClasspath(userOption);
    }

    // 启动类和扩展类路径
    private void bootstrapAndExtensionClasspath(String jreOption) {
        // 获取jre目录
        String jreDir = getJreDir(jreOption);
        // 获取jre/lib路径
        String jreLibPath = Paths.get(jreDir, "lib") + File.pathSeparator + "*";
        // 创建启动类路径
        bootstrapClasspath = new WildcardEntry(jreLibPath);

        // 获取jre/lib/ext路径
        String jreLibExtPath = Paths.get(jreDir, "lib", "ext") + File.pathSeparator + "*";
        // 创建扩展类路径
        extensionClasspath = new WildcardEntry(jreLibExtPath);
    }

    // 获取jre目录
    private static String getJreDir(String jreOption) {
        // 自定义的路径如果在环境变量中已经配置，则直接返回
        if (jreOption != null && Files.exists(Paths.get(jreOption))) return jreOption;

        // "./jre"路径如果在环境变量中已经配置，则直接返回
        if (Files.exists(Paths.get("./jre"))) return "./jre";

        // 获取JDK环境变量
        String javaHome = System.getenv("JAVA_HOME");
        // 如果存在jdk环境变量则获取环境变量路径
        if (javaHome != null) return Paths.get(javaHome, "jre").toString();

        // 找不到任何的jre路径则抛出异常
        throw new RuntimeException("Can not find JRE folder!");
    }

    // 解析用户类路径
    private void parseUserClasspath(String userOption) {
        if (userOption == null) userOption = ".";

        userClasspath = Entry.create(userOption);
    }

    // 读取类文件获取字节码
    public byte[] readClass(String className) throws IOException {
        className = className + ".class";

        // 启动类路径
        try {
            return bootstrapClasspath.readClass(className);
        } catch (Exception e) {}

        // 扩展类路径
        try {
            return extensionClasspath.readClass(className);
        } catch (Exception e) {}

        // 用户类路径
        return userClasspath.readClass(className);
    }

}
