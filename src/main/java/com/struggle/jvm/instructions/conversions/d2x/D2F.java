package com.struggle.jvm.instructions.conversions.d2x;

import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//convert double to float
public class D2F extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double d = stack.popDouble();
        float f = (float) d;
        stack.pushFloat(f);
    }

}
