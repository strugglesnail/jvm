package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 字段或方法的部分符号引用
 */
public class ConstantNameAndTypeInfo implements ConstantInfo {

    // u2类型，指向该字段或方法名称常量项的索引
    public int nameIdx;
    // u2类型，指向该字段或方法描述符常量项的索引
    public int descIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIdx = reader.readUint16();
        this.descIdx = reader.readUint16();
    }

    // u1类型，值为12
    @Override
    public int tag() {
        return this.CONSTANT_TAG_NAMEANDTYPE;
    }
}
