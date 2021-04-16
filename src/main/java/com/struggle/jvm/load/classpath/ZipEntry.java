package com.struggle.jvm.load.classpath;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author strugglesnail
 * @date 2021/4/14
 * @desc 压缩包形式路径
 */
public class ZipEntry implements Entry {

    // 绝对路径
    private Path absolutePath;

    public ZipEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        try (FileSystem fs = FileSystems.newFileSystem(absolutePath, null)){
            return Files.readAllBytes(fs.getPath(className));
        }
    }

    @Override
    public String toString() {
        return absolutePath.toString();
    }
}
