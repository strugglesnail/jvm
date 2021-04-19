package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 长整型字面量
 */
public class ConstantLongInfo implements ConstantInfo {

    // u8类型，按高位在前存储的int值
    private long value;

    @Override
    public void readInfo(ClassReader reader) {
        this.value = reader.readUint64TLong();
    }

    // u1类型，值为5
    @Override
    public int tag() {
        return this.CONSTANT_TAG_FLOAT;
    }

    public long getValue() {
        return value;
    }
}
