package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 表示一个动态方法调用点
 */
public class ConstantInvokeDynamicInfo implements ConstantInfo {

    // u2类型，值必须是对当前Class文件中引导方法表的bootstrap_methods[]数组的有效索引
    private int bootstrapMethodAttrIdx;

    // u2类型，值必须是对当前常量池的有效索引，
    // 常量池在该索引处的项必须是CONSTANT_NameAndType_info结构，表示方法名和方法描述
    private int nameAndTypeIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.bootstrapMethodAttrIdx = reader.readUint16();
        this.nameAndTypeIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INVOKEDYNAMIC;
    }
}
