package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 字段的符号引用
 */
public class ConstantFieldRefInfo extends ConstantMemberRefInfo {

    public ConstantFieldRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    // u1类型，值为9
    @Override
    public int tag() {
        return this.CONSTANT_TAG_FIELDREF;
    }
}
