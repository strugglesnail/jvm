package com.struggle.jvm.instructions.conversions.d2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

public class D2I extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double d = stack.popDouble();
        int i = (int) d;
        stack.pushInt(i);
    }

}
