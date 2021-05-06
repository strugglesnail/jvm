package com.struggle.jvm.instructions.conversions.i2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//convert int to double
public class I2D extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int i = stack.popInt();
        double d = i;
        stack.pushDouble(d);
    }

}