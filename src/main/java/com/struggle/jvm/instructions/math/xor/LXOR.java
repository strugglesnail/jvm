package com.struggle.jvm.instructions.math.xor;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//boolean xor long
public class LXOR extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long v1 = stack.popLong();
        long v2 = stack.popLong();
        long res = v1 ^ v2;
        stack.pushLong(res);
    }

}

