package com.struggle.jvm.parse.attributes.impl;


import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.attributes.AttributeInfo;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/26
 */
public class ConstantValueAttribute implements AttributeInfo {

    private int constantValueIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.constantValueIdx = reader.readUint16();
    }

    public int constantValueIdx(){
        return this.constantValueIdx;
    }

}
