package com.struggle.jvm.parse.attributes.impl;


import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.attributes.AttributeInfo;

/**
 */
public class ExceptionsAttribute implements AttributeInfo {

    private int[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader) {
        this.exceptionIndexTable = reader.readUint16s();
    }

    public int[] exceptionIndexTable(){
        return this.exceptionIndexTable;
    }

}
