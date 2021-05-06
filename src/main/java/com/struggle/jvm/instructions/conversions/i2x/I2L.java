package com.struggle.jvm.instructions.conversions.i2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//convert int to long
public class I2L extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int i = stack.popInt();
        long l = i;
        stack.pushLong(l);
    }

}
