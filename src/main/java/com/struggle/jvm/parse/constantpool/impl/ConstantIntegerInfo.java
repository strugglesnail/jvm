package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 整型字面量
 */
public class ConstantIntegerInfo implements ConstantInfo {

    // u2类型按高位在前存储的int值
    private int value;

    @Override
    public void readInfo(ClassReader reader) {
        this.value = reader.readUint32TInteger();
    }

    // u1类型，值为3
    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTEGER;
    }

    public int getValue() {
        return value;
    }
}
