package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 标识方法类型
 */
public class ConstantMethodTypeInfo implements ConstantInfo {

    // u2类型，值必须对常量池的有效索引，
    // 常量池在该索引处的项必须CONSTANT_Utf8_info结构，表示方法描述符
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
