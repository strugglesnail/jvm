package com.struggle.jvm.parse;


import com.struggle.jvm.parse.attributes.AttributeInfo;
import com.struggle.jvm.parse.attributes.impl.CodeAttribute;
import com.struggle.jvm.parse.attributes.impl.ConstantValueAttribute;
import com.struggle.jvm.parse.constantpool.ConstantPool;

/**
 * @author strugglesnail
 * @date 2021/4/21 15:06
 * @desc 成员信息
 */
public class MemberInfo {

    // 常量信息
    private ConstantPool constantPool;
    // 访问权限
    private int accessFlags;
    // 常量池索引（方法名称）
    private int nameIdx;
    // 常量池索引（方法参数类型及返回类型）
    private int descriptorIdx;
    // Code属性、LineNumberTable及异常表
    private AttributeInfo[] attributes;

    private MemberInfo(ClassReader reader, ConstantPool constantPool) {
        this.constantPool = constantPool;
        this.accessFlags = reader.readUint16();
        this.nameIdx = reader.readUint16();
        this.descriptorIdx = reader.readUint16();
        this.attributes = AttributeInfo.readAttributes(reader, constantPool);
    }

    static MemberInfo[] readMembers(ClassReader reader, ConstantPool constantPool) {
        int memberCount = reader.readUint16();
        MemberInfo[] members = new MemberInfo[memberCount];
        for (int i = 0; i < memberCount; i++) {
            members[i] = new MemberInfo(reader, constantPool);
        }
        return members;
    }

    public int accessFlags() {
        return this.accessFlags;
    }

    public String name() {
        return this.constantPool.getUTF8(this.nameIdx);
    }

    public String descriptor() {
        return this.constantPool.getUTF8(this.descriptorIdx);
    }

    public CodeAttribute codeAttribute() {
        for (AttributeInfo attrInfo : attributes) {
            if (attrInfo instanceof CodeAttribute) return (CodeAttribute) attrInfo;
        }
        return null;
    }

    public ConstantValueAttribute constantValueAttribute() {
        for (AttributeInfo attrInfo : attributes) {
            if (attrInfo instanceof ConstantValueAttribute) return (ConstantValueAttribute) attrInfo;
        }
        return null;
    }

}
