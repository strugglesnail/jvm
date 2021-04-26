package com.struggle.jvm.parse.constantpool;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.impl.ConstantClassInfo;
import com.struggle.jvm.parse.constantpool.impl.ConstantNameAndTypeInfo;
import com.struggle.jvm.parse.constantpool.impl.ConstantUtf8Info;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther strugglesnail
 * @date 2021/4/18 10:01
 * @desc
 */
public class ConstantPool {

    // 常量信息
    private ConstantInfo[] constantInfos;

    private final int siz;

    public ConstantPool(ClassReader reader) {
        siz = reader.readUint16();
        System.out.println(siz);
        constantInfos = new ConstantInfo[siz];
        for (int i = 1; i < siz; i++) {
            constantInfos[i] = ConstantInfo.readConstantInfo(reader, this);
            switch (constantInfos[i].tag()) {
                case ConstantInfo.CONSTANT_TAG_DOUBLE:
                case ConstantInfo.CONSTANT_TAG_LONG:
                    i++;
                    break;
            }
        }
    }

    public Map<String, String> getNameAndType(int idx) {
        ConstantNameAndTypeInfo constantInfo = (ConstantNameAndTypeInfo) this.constantInfos[idx];
        Map<String, String> map = new HashMap<>();
        map.put("name", this.getUTF8(constantInfo.nameIdx));
        map.put("_type", this.getUTF8(constantInfo.descIdx));
        return map;
    }

    public String getClassName(int idx){
        ConstantClassInfo classInfo = (ConstantClassInfo) this.constantInfos[idx];
        return this.getUTF8(classInfo.nameIdx);
    }


    public String getUTF8(int idx) {
        ConstantUtf8Info utf8Info = (ConstantUtf8Info) this.constantInfos[idx];
        return utf8Info == null ? "" : utf8Info.str();
    }


    public ConstantInfo[] getConstantInfos() {
        return constantInfos;
    }

    public void setConstantInfos(ConstantInfo[] constantInfos) {
        this.constantInfos = constantInfos;
    }

    public int getSiz() {
        return siz;
    }


}
