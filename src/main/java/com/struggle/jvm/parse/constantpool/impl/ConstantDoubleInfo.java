package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 双精度浮点型字面量
 */
public class ConstantDoubleInfo implements ConstantInfo {

    // u8类型，按高位在前存储的double值
    private double value;

    @Override
    public void readInfo(ClassReader reader) {
        this.value = reader.readUint64TDouble();
    }

    // u1类型，值为6
    @Override
    public int tag() {
        return this.CONSTANT_TAG_DOUBLE;
    }

    public double getValue() {
        return value;
    }
}
