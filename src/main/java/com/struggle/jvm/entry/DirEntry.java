package com.struggle.jvm.entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author strugglesnail
 * @date 2021/4/14
 * @desc 目录形式路径
 */
public class DirEntry implements Entry {

    // 绝对路径
    private Path absolutePath;

    public DirEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absolutePath.resolve(className));
    }

    @Override
    public String toString() {
        return absolutePath.toString();
    }
}
