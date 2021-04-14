package com.struggle.jvm.entry;

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
//File.pathSeparator；路径分隔符(win\linux)
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }
        if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }
}
