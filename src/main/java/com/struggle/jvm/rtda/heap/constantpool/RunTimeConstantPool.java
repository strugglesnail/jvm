package com.struggle.jvm.rtda.heap.constantpool;

import com.struggle.jvm.parse.constantpool.ConstantInfo;
import com.struggle.jvm.parse.constantpool.ConstantPool;
import com.struggle.jvm.parse.constantpool.impl.*;
import com.struggle.jvm.rtda.heap.methodarea.Class;

/**
 * @author strugglesnail
 * @date 2021/5/6
 * @desc
 */
public class RunTimeConstantPool {

    // 类对象
    private Class aClass;

    // 常量池
    private Object[] constants;

    public RunTimeConstantPool(Class aClass, ConstantPool constantPool) {
        ConstantInfo[] constantInfos = constantPool.getConstantInfos();
        int cpCount = constantInfos.length;
        this.aClass = aClass;
        for (int i = 1; i < cpCount; i++) {
            ConstantInfo constantInfo = constantInfos[i];
            switch (constantInfo.tag()) {
                case ConstantInfo.CONSTANT_TAG_INTEGER:
                    ConstantIntegerInfo constantIntegerInfo = (ConstantIntegerInfo) constantInfos[i];
                    this.constants[i] = constantIntegerInfo.getValue();
                    break;
                case ConstantInfo.CONSTANT_TAG_FLOAT:
                    ConstantFloatInfo floatInfo = (ConstantFloatInfo) constantInfos[i];
                    this.constants[i] = floatInfo.getValue();
                    break;
                case ConstantInfo.CONSTANT_TAG_LONG:
                    ConstantLongInfo longInfo = (ConstantLongInfo) constantInfos[i];
                    this.constants[i] = longInfo.getValue();
                    i++;
                    break;
                case ConstantInfo.CONSTANT_TAG_DOUBLE:
                    ConstantDoubleInfo doubleInfo = (ConstantDoubleInfo) constantInfos[i];
                    this.constants[i] = doubleInfo.getValue();
                    i++;
                    break;
                case ConstantInfo.CONSTANT_TAG_STRING:
                    ConstantStringInfo stringInfo = (ConstantStringInfo) constantInfos[i];
                    this.constants[i] = stringInfo.string();
                    break;
                case ConstantInfo.CONSTANT_TAG_CLASS:
                    break;
                case ConstantInfo.CONSTANT_TAG_FIELDREF:
                    break;
                case ConstantInfo.CONSTANT_TAG_INTERFACEMETHODREF:
                    break;
                case ConstantInfo.CONSTANT_TAG_METHODREF:
                    break;
            }
        }
    }
}
