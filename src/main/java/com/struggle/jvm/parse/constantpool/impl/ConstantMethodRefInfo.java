package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc
 */
public class ConstantMethodRefInfo extends ConstantMemberRefInfo {

    public ConstantMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }
    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODREF;
    }

}
