package com.struggle.jvm.parse.attributes.impl;


import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.attributes.AttributeInfo;
import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 */
public class SignatureAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int signatureIdx;

    public SignatureAttribute(ConstantPool constantPool) {
          this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.signatureIdx = reader.readUint16();
    }

    public String signature(){
        return this.constantPool.getUTF8(this.signatureIdx);
    }

}
