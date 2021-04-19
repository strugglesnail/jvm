package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc
 */
public class ConstantMethodHandleInfo implements ConstantInfo {

    // u1值必须在1~9之间（包括1~9），它决定了方法句柄的类型。方法句柄类型的值表示方法句柄的字节码行为
    private int referenceKind;

    // u2值必须是对常量的有效索引
    private int referenceIndex;

    @Override
    public void readInfo(ClassReader reader) {
        // 1个字节8位
        this.referenceKind = reader.readUint8();
        // 2个字节16位
        this.referenceIndex = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODHANDLE;
    }
}
