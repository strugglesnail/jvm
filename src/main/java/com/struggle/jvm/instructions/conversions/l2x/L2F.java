package com.struggle.jvm.instructions.conversions.l2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//convert long to float
public class L2F extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long l = stack.popLong();
        float f = l;
        stack.pushFloat(f);
    }

}
