package com.struggle.jvm.instructions.comparisons.lcmp;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

public class LCMP extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if (v1 > v2) {
            stack.pushInt(1);
            return;
        }
        if (v1 == v2) {
            stack.pushInt(0);
            return;
        }
        stack.pushInt(-1);
    }
}
