package com.struggle.jvm.parse.constantpool;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.impl.*;

/**
 * @auther strugglesnail
 * @date 2021/4/18 09:18
 * @desc 常量信息
 */
public interface ConstantInfo {

    int CONSTANT_TAG_UTF8 = 1;                // UTF-8编码的字符串
    int CONSTANT_TAG_INTEGER = 3;             // 整型字面量
    int CONSTANT_TAG_FLOAT = 4;               // 浮点型字面量
    int CONSTANT_TAG_LONG = 5;                // 长整型字面量
    int CONSTANT_TAG_DOUBLE = 6;              // 双精度浮点型字面量
    int CONSTANT_TAG_CLASS = 7;               // 类或接口的符号字面量
    int CONSTANT_TAG_STRING = 8;              // 字符串的符号引用
    int CONSTANT_TAG_FIELDREF = 9;            // 字段的符号引用
    int CONSTANT_TAG_METHODREF = 10;          // 类中方法的符号引用
    int CONSTANT_TAG_INTERFACEMETHODREF = 11; // 接口中方法的符号引用
    int CONSTANT_TAG_NAMEANDTYPE = 12;        // 字段或方法的部分符号引用
    int CONSTANT_TAG_METHODHANDLE = 15;       // 表示方法句柄
    int CONSTANT_TAG_METHODTYPE = 16;         // 标识方法类型
    int CONSTANT_TAG_INVOKEDYNAMIC = 18;      // 表示一个动态方法调用点

    // 阅读信息
    void readInfo(ClassReader reader);

    // 标签
    int tag();

    // 读取常量信息
    static ConstantInfo readConstantInfo(ClassReader reader, ConstantPool pool) {
        // 标签
        int tag = reader.readUint8();
        // 常量信息实现类
        ConstantInfo constantInfo = newConstantInfo(tag, pool);
        // 读取常量信息
        constantInfo.readInfo(reader);
        return constantInfo;
    }

    // 获取常量信息
    static ConstantInfo newConstantInfo(int tag, ConstantPool pool) {
        switch (tag) {
            case CONSTANT_TAG_UTF8:
                return new ConstantUtf8Info();
            case CONSTANT_TAG_INTEGER:
                return new ConstantIntegerInfo();
            case CONSTANT_TAG_FLOAT:
                return new ConstantFloatInfo();
            case CONSTANT_TAG_LONG:
                return new ConstantLongInfo();
            case CONSTANT_TAG_DOUBLE:
                return new ConstantDoubleInfo();
            case CONSTANT_TAG_CLASS:
                return new ConstantClassInfo(pool);
            case CONSTANT_TAG_STRING:
                return new ConstantStringInfo(pool);
            case CONSTANT_TAG_FIELDREF:
                return new ConstantFieldRefInfo(pool);
            case CONSTANT_TAG_METHODREF:
                return new ConstantMethodRefInfo(pool);
            case CONSTANT_TAG_INTERFACEMETHODREF:
                return new ConstantInterfaceMethodRefInfo(pool);
            case CONSTANT_TAG_NAMEANDTYPE:
                return new ConstantNameAndTypeInfo();
            case CONSTANT_TAG_METHODTYPE:
                return new ConstantMethodTypeInfo();
            case CONSTANT_TAG_INVOKEDYNAMIC:
                return new ConstantInvokeDynamicInfo();
            default:
                throw new ClassFormatError("constant pool tag");
        }
    }
}
