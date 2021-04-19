package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc
 */
public class ConstantMethodRefInfo implements ConstantInfo {

    private long value;

    @Override
    public void readInfo(ClassReader reader) {
        this.value = reader.readUint64TLong();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FLOAT;
    }

    public long getValue() {
        return value;
    }
}
