package com.struggle.jvm.instructions.constants.ldc;

import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.parse.constantpool.ConstantPool;
import com.struggle.jvm.stack.StackFrame;

/**
 * @author strugglesnail
 * @date 2021/5/2
 * @desc 将int，float，String型常量值从常量池中推送至栈顶
 */
public class LDC implements Instruction {

    int idx;

    private ConstantPool constantPool;


    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.readByte();
    }

    @Override
    public void execute(StackFrame frame) {
        String className = constantPool.getUTF8(idx);

    }
}
