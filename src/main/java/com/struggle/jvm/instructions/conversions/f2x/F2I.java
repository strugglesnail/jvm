package com.struggle.jvm.instructions.conversions.f2x;

import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//convert float to int
public class F2I extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float f = stack.popFloat();
        int i = (int) f;
        stack.pushInt(i);
    }
}
