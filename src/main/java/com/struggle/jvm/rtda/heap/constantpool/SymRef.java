package com.struggle.jvm.rtda.heap.constantpool;

import com.struggle.jvm.rtda.heap.methodarea.Class;

/**
 * @author strugglesnail
 * @date 2021/5/7
 * @desc
 */
public class SymRef {
    public RunTimeConstantPool runTimeConstantPool;
    public String className;
    public Class clazz;

    public Class resolvedClass() {
        if (null != this.clazz) return this.clazz;
        Class d = this.runTimeConstantPool.getClazz();
        Class c = d.loader.loadClass(this.className);;
        this.clazz = c;
        return this.clazz;
    }

}
