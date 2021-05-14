package com.struggle.jvm.rtda.heap.methodarea;

import com.struggle.jvm.parse.MemberInfo;
import com.struggle.jvm.parse.attributes.impl.CodeAttribute;
import com.struggle.jvm.rtda.heap.constantpool.AccessFlags;

/**
 * @author strugglesnail
 * @date 2021/5/7
 * @desc
 */
public class Method extends ClassMember {

    public int maxStack;
    public int maxLocals;
    public byte[] code;

    public Method[] newMethods(Class clazz, MemberInfo[] cfMethods) {
        Method[] methods = new Method[cfMethods.length];
        for (int i = 0; i < cfMethods.length; i++) {
            methods[i] = new Method();
            methods[i].clazz = clazz;
            methods[i].copyMemberInfo(cfMethods[i]);
            methods[i].copyAttributes(cfMethods[i]);
        }
        return methods;
    }

    public void copyAttributes(MemberInfo memberInfo) {
        CodeAttribute codeAttribute = memberInfo.codeAttribute();
        if (codeAttribute != null) {
            this.maxLocals = codeAttribute.maxLocals();
            this.maxStack = codeAttribute.maxStack();
            this.code = codeAttribute.data();
        }
    }

    public boolean isSynchronized() {
        return 0 != (this.accessFlags & AccessFlags.ACC_SYNCHRONIZED);
    }

    public boolean isBridge() {
        return 0 != (this.accessFlags & AccessFlags.ACC_BRIDGE);
    }

    public boolean isVarargs() {
        return 0 != (this.accessFlags & AccessFlags.ACC_VARARGS);
    }

    public boolean isNative() {
        return 0 != (this.accessFlags & AccessFlags.ACC_NATIVE);
    }

    public boolean isAbstract() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ABSTRACT);
    }

    public boolean isStrict() {
        return 0 != (this.accessFlags & AccessFlags.ACC_STRICT);
    }

    public int maxStack() {
        return this.maxStack;
    }

    public int maxLocals() {
        return this.maxLocals;
    }

    public byte[] code() {
        return this.code;
    }
}
