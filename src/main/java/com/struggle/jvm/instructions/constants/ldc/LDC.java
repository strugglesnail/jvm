package com.struggle.jvm.instructions.constants.ldc;

import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.parse.constantpool.ConstantPool;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

/**
 * @author strugglesnail
 * @date 2021/5/2
 * @desc 将int，float，String型常量值从常量池中推送至栈顶
 */
public class LDC implements Instruction {

    int idx;

    private ConstantPool constantPool;

    public LDC(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        idx = reader.readByte();
    }

    @Override
    public void execute(StackFrame frame) {
        String string = constantPool.getString(idx);
//        System.out.println("LDC: " + string);
        OperandStack operandStack = frame.getOperandStack();
        operandStack.pushRef(string);
    }
}
