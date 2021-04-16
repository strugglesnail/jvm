package com.struggle.jvm.load.classpath;

import java.io.File;
import java.io.IOException;

/**
 * @author strugglesnail
 * @date 2021/4/14
 * @desc 类路径接口
 */
public interface Entry {

    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {

        // File.pathSeparator；路径分隔符(win\linux)
        if (path.contains(File.pathSeparator)) return new CompositeEntry(path);

        // 通配符匹配
        if (path.endsWith("*")) return new WildcardEntry(path);

        // jar/zip匹配
        if (path.endsWith(".jar") || path.endsWith(".JAR") || path.endsWith(".zip") || path.endsWith(".ZIP")) return new ZipEntry(path);
        // 目录匹配
        return new DirEntry(path);
    }
}
