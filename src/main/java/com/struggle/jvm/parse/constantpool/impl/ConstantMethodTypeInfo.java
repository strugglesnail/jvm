package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc
 */
public class ConstantMethodTypeInfo implements ConstantInfo {

    private int descriptorIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.descriptorIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODTYPE;
    }
}
