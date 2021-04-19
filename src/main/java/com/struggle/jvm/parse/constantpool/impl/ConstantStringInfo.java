package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;
import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 字符串类型字面量
 */
public class ConstantStringInfo implements ConstantInfo {

    private ConstantPool constantPool;

    // u2类型，指向字符串字面量的索引(2个字节长度)
    private int strIdx;

    public ConstantStringInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.strIdx = reader.readUint16();
    }

    // u1类型，值为8
    @Override
    public int tag() {
        return this.CONSTANT_TAG_STRING;
    }

    public String string(){
        return this.constantPool.getUTF8(this.strIdx);
    }
}
