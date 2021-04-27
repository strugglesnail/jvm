package com.struggle.jvm.instructions.math.neg;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//negate int
public class INEG extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int val = stack.popInt();
        stack.pushDouble(-val);
    }

}

