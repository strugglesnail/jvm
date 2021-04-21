package com.struggle.jvm.parse.attributes.impl;


import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.attributes.AttributeInfo;
import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 */
public class SourceFileAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int sourceFileIdx;

    public SourceFileAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.sourceFileIdx = reader.readUint16();
    }

    public String fileName(){
        return this.constantPool.getUTF8(this.sourceFileIdx);
    }

}
