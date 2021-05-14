package com.struggle.jvm.rtda.heap;

import com.struggle.jvm.load.Classpath;
import com.struggle.jvm.parse.ClassFile;
import com.struggle.jvm.rtda.heap.constantpool.RunTimeConstantPool;
import com.struggle.jvm.rtda.heap.methodarea.Class;
import com.struggle.jvm.rtda.heap.methodarea.Field;
import com.struggle.jvm.rtda.heap.methodarea.Slots;


import java.util.HashMap;
import java.util.Map;

/**
 * @author strugglesnail
 * @date 2021/5/6
 * @desc 类加载器
 */
public class ClassLoader {

    private Classpath classpath;
    private Map<String, Class> classMap;

    public ClassLoader(Classpath classpath) {
        this.classpath = classpath;
        this.classMap = new HashMap<>();
    }

    // 加载
    public Class loadClass(String className) {
        Class clazz = classMap.get(className);
        if (clazz != null) return clazz;
        try {
            return loadNonArrayClass(className);
        } catch (Exception e) {

        }
        return null;
    }

    // 加载非数组的Class
    private Class loadNonArrayClass(String className) throws Exception {
        byte[] data = this.classpath.readClass(className);
        if (data == null) {
            throw new ClassNotFoundException(className);
        }
        // 加载

        // 【验证、准备、解析、初始化】连接
        return null;
    }

    private Class defineClass(byte[] data) throws Exception {
        // 字节转换成Class
        Class clazz = parseClass(data);
        // 赋值类加载器
        clazz.loader = this;
        // 解析父类
        resolveSuperClass(clazz);
        // 解析接口
        resolveInterfaces(clazz);
        // 缓存该类
        classMap.put(clazz.name, clazz);
        return clazz;
    }
        // 连接
    void link() {
        // 验证
        // 准备

    }

    // 验证
    private void verify(Class clazz) {
        // 校验字节码，尚未实现
    }
    // 准备（为类变量分配内存并设置类变量初始化阶段）
    private void prepare(Class clazz) {
        // 计算字段位数
    }

    // 赋值所有接口
    private void resolveInterfaces(Class clazz) throws Exception {
        int interfaceCount = clazz.interfaceNames.length;
        if (interfaceCount > 0) {
            clazz.interfaces = new Class[interfaceCount];
            for (int i = 0; i < interfaceCount; i++) {
                clazz.interfaces[i] = clazz.loader.loadClass(clazz.interfaceNames[i]);
            }
        }
    }

    // 赋值父类
    private void resolveSuperClass(Class clazz) throws Exception {
        if (!clazz.name.equals("java/lang/Object")) {
            clazz.superClass = clazz.loader.loadClass(clazz.superClassName);
        }
    }


    // 创建Class类
    private Class parseClass(byte[] data) {
        // 类结构
        ClassFile classFile = new ClassFile(data);
        return new Class(classFile);
    }

    // 计算字段实列位数
    private void calcInstanceFieldSlotIds(Class clazz) {
        int slotId = 0;
        if (clazz.superClass != null) {
            slotId = clazz.superClass.instanceSlotCount;
        }
        for (Field field : clazz.fields) {
            if (!field.isStatic()) {
                field.slotId = slotId;
                slotId ++;
                if (field.isLongOrDouble()) {
                    slotId ++;
                }
            }
        }
    }

    // 计算静态变量位数
    private void calcStaticFieldSlotIds(Class clazz) {
        int slotId = 0;
        for (Field field : clazz.fields) {
            if (field.isStatic()) {
                field.slotId = slotId;
                slotId++;
                if (field.isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        clazz.staticSlotCount = slotId;
    }

    // 静态变量分配内存并且初始化值
    private void allocAndInitStaticVars(Class clazz) {
        clazz.staticVars = new Slots(clazz.staticSlotCount);
        for (Field field : clazz.fields) {
            if (field.isStatic() && field.isFinal()) {
                // 初始化静态变量

            }
        }
    }

    private void initStaticFinalVar(Class clazz, Field field) {
        Slots slots = clazz.staticVars;
        RunTimeConstantPool runTimeConstantPool = clazz.runTimeConstantPool;
        int cpIdx = field.constValueIndex();
        int slotId = field.slotId();
        if (cpIdx > 0) {
            Object constants = runTimeConstantPool.getConstants(slotId);
            switch (field.descriptor()) {
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    slots.setInt(slotId, (Integer) constants);
                    break;
                case "J":
                    slots.setLong(slotId, (Long) constants);
                    break;
                case "F":
                    slots.setFloat(slotId, (Float) constants);
                    break;
                case "D":
                    slots.setDouble(slotId, (Double) constants);
                    break;
                case "Ljava/lang/String;":
                    System.out.println("todo");

            }
        }
    }
}
