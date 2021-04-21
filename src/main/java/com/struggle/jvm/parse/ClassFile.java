package com.struggle.jvm.parse;


import com.struggle.jvm.parse.attributes.AttributeInfo;
import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 * @author strugglesnail
 * @date 2021/4/21 15:14
 * @desc Class文件结构
 */
public class ClassFile {

    // u4类型，魔数4个字节
    private int minorVersion;
    // 主版本号
    private int majorVersion;
    // 常量池
    private ConstantPool constantPool;
    // 访问权限
    private int accessFlags;
    // 当前类
    private int thisClassIdx;
    // 父类
    private int supperClassIdx;
    // 接口表
    private int[] interfaces;
    // 字段表
    private MemberInfo[] fields;
    // 方法表
    private MemberInfo[] methods;
    // 属性表
    private AttributeInfo[] attributes;

    public ClassFile(byte[] classData) {
        ClassReader reader = new ClassReader(classData);
        this.readAndCheckMagic(reader);
        this.readAndCheckVersion(reader);
        this.constantPool = this.readConstantPool(reader);
        this.accessFlags = reader.readUint16();
        this.thisClassIdx = reader.readUint16();
        this.supperClassIdx = reader.readUint16();
        this.interfaces = reader.readUint16s();
        this.fields = MemberInfo.readMembers(reader, constantPool);
        this.methods = MemberInfo.readMembers(reader, constantPool);
        this.attributes = AttributeInfo.readAttributes(reader, constantPool);
    }

    private void readAndCheckMagic(ClassReader reader) {
        long magic = reader.readUint32();
        if (magic != (0xCAFEBABE & 0x0FFFFFFFFL)) {
            throw new ClassFormatError("magic!");
        }
    }

    private void readAndCheckVersion(ClassReader reader) {
        this.minorVersion = reader.readUint16();
        this.majorVersion = reader.readUint16();
        switch (this.majorVersion) {
            case 45:
                return;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                if (this.minorVersion == 0)
                    return;
        }
        throw new UnsupportedClassVersionError();
    }

    private ConstantPool readConstantPool(ClassReader reader) {
        return new ConstantPool(reader);
    }

    public int minorVersion() {
        return this.minorVersion;
    }

    public int majorVersion() {
        return this.majorVersion;
    }

    public ConstantPool constantPool() {
        return this.constantPool;
    }

    public int accessFlags() {
        return this.accessFlags;
    }

    public MemberInfo[] fields() {
        return this.fields;
    }

    public MemberInfo[] methods() {
        return this.methods;
    }

    public String className() {
        return this.constantPool.getClassName(this.thisClassIdx);
    }

    public String superClassName() {
        if (this.supperClassIdx <= 0) return "";
        return this.constantPool.getClassName(this.supperClassIdx);
    }

    public String[] interfaceNames() {
        String[] interfaceNames = new String[this.interfaces.length];
        for (int i = 0; i < this.interfaces.length; i++) {
            interfaceNames[i] = this.constantPool.getClassName(interfaces[i]);
        }
        return interfaceNames;
    }

}
