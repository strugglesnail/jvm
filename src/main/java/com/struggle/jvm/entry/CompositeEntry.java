package com.struggle.jvm.entry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author strugglesnail
 * @date 2021/4/14
 * @desc 混合形式路径
 */
public class CompositeEntry implements Entry {

    private final List<Entry> entryList = new ArrayList<>();

    public CompositeEntry(String pathList) {
        // 获取多个文件路径
        String[] paths = pathList.split(File.pathSeparator);
        for (String path : paths) {
            // 保存类路径
            entryList.add(Entry.create(path));
        }
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        for (Entry entry : entryList) {
            try {
                return entry.readClass(className);
            } catch (Exception e) {

            }
        }
        throw new IOException(className + "not found!");
    }

    @Override
    public String toString() {
        String[] strs = new String[entryList.size()];
        for (int i = 0; i < entryList.size(); i++) {
            strs[i] = entryList.get(i).toString();
        }
        return String.join(File.pathSeparator, strs);
    }
}
