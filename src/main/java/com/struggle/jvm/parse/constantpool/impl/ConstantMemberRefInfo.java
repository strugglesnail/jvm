package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;
import com.struggle.jvm.parse.constantpool.ConstantPool;

import java.util.Map;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc
 */
public class ConstantMemberRefInfo implements ConstantInfo {

    protected ConstantPool constantPool;
    /**
     * u2类型，指向声明
     * 【字段的类或者接口】
     * 【方法的接口】
     * 【方法的接口】
     * 描述符CONSTANT_Class_info的索引项
      */

    //
    //
    protected int classIdx;
    // u2类型，指向字段描述符CONSTANT_NameAndType的索引项
    private int nameAndTypeIdx;

    public ConstantMemberRefInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.classIdx = reader.readUint16();
        this.nameAndTypeIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return 0;
    }

    public String className() {
        return this.constantPool.getClassName(this.classIdx);
    }

    public Map<String, String> nameAndDescriptor() {
        return this.constantPool.getNameAndType(this.nameAndTypeIdx);
    }

}
