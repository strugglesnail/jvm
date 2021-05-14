package com.struggle.jvm.rtda.heap.methodarea;

import com.struggle.jvm.parse.MemberInfo;
import com.struggle.jvm.parse.attributes.impl.ConstantValueAttribute;
import com.struggle.jvm.rtda.heap.constantpool.AccessFlags;

/**
 * @author strugglesnail
 * @date 2021/5/7
 * @desc
 */
public class Field extends ClassMember {

    public int constValueIndex;
    public int slotId;


    public Field[] newFields(Class clazz, MemberInfo[] cfFields) {
        Field[] fields = new Field[cfFields.length];
        for (int i = 0; i < cfFields.length; i++) {
            fields[i] = new Field();
            fields[i].clazz = clazz;
            fields[i].copyMemberInfo(cfFields[i]);
            fields[i].copyAttributes(cfFields[i]);
        }
        return fields;
    }


    public void copyAttributes(MemberInfo memberInfo) {
        ConstantValueAttribute attribute = memberInfo.constantValueAttribute();
        if (attribute != null) {
            this.constValueIndex = attribute.constantValueIdx();
        }
    }

    public boolean isVolatile() {
        return 0 != (this.accessFlags & AccessFlags.ACC_VOLATILE);
    }

    public boolean isTransient() {
        return 0 != (this.accessFlags & AccessFlags.ACC_TRANSIENT);
    }

    public boolean isEnum() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ENUM);
    }

    public int constValueIndex() {
        return this.constValueIndex;
    }

    public int slotId() {
        return this.slotId;
    }

    public boolean isLongOrDouble() {
        return this.descriptor.equals("J") || this.descriptor.equals("D");
    }
}
