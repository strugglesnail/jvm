package com.struggle.jvm.parse.attributes.impl;


import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.attributes.AttributeInfo;

/**
 */
public class InnerClassesAttribute implements AttributeInfo {

    private InnerClassInfo[] classes;

    @Override
    public void readInfo(ClassReader reader) {
        int numberOfClasses = reader.readUint16();
        this.classes = new InnerClassInfo[numberOfClasses];
        for (int i = 0; i < numberOfClasses; i++) {
            classes[i] = new InnerClassInfo(reader.readUint16(), reader.readUint16(), reader.readUint16(), reader.readUint16());
        }
    }

    static class InnerClassInfo {

        private int innerClassInfoIndex;
        private int outerClassInfoIndex;
        private int innerNameIndex;
        private int innerClassAccessFlags;

        InnerClassInfo(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccessFlags) {
            this.innerClassInfoIndex = innerClassInfoIndex;
            this.outerClassInfoIndex = outerClassInfoIndex;
            this.innerNameIndex = innerNameIndex;
            this.innerClassAccessFlags = innerClassAccessFlags;
        }
    }

}
