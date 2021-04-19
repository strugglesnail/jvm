package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 浮点型字面量
 */
public class ConstantFloatInfo implements ConstantInfo {

    // u4类型按高位在前存储的float值
    private float value;

    @Override
    public void readInfo(ClassReader reader) {
        this.value = reader.readUint64TFloat();
    }

    // u1类型，值为4
    @Override
    public int tag() {
        return this.CONSTANT_TAG_FLOAT;
    }

    public float getValue() {
        return value;
    }
}
