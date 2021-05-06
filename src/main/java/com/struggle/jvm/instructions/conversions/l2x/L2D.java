package com.struggle.jvm.instructions.conversions.l2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//convert long to double
public class L2D extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long l = stack.popLong();
        float f = l;
        stack.pushFloat(f);
    }

}
