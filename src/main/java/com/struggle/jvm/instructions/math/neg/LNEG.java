package com.struggle.jvm.instructions.math.neg;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//negate long
public class LNEG extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long val = stack.popLong();
        stack.pushLong(-val);
    }

}
