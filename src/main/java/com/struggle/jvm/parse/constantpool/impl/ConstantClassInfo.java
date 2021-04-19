package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;
import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 类或接口的符号引用
 */
public class ConstantClassInfo implements ConstantInfo {

    // 关联的常量池
    public ConstantPool constantPool;
    // u2类型，指向权限定名常量项的索引(最长2个字节长度)
    public int nameIdx;

    public ConstantClassInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIdx = reader.readUint16();
    }

    // u1类型，值为7
    @Override
    public int tag() {
        return this.CONSTANT_TAG_CLASS;
    }

    public String name(){
        return this.constantPool.getUTF8(this.nameIdx);
    }
}
