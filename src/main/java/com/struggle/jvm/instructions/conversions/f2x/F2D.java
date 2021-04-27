package com.struggle.jvm.instructions.conversions.f2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

// convert float to double
public class F2D extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float f = stack.popFloat();
        double d = f;
        stack.pushDouble(d);
    }

}
