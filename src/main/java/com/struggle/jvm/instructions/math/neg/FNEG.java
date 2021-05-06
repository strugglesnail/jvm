package com.struggle.jvm.instructions.math.neg;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//negate float
public class FNEG extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float val = stack.popFloat();
        stack.pushDouble(-val);
    }

}
