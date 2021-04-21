package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 接口中方法的符号引用
 */
public class ConstantInterfaceMethodRefInfo extends ConstantMemberRefInfo {

    public ConstantInterfaceMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    // u1类型，值为11
    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTERFACEMETHODREF;
    }
}
