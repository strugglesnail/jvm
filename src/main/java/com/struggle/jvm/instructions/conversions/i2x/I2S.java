package com.struggle.jvm.instructions.conversions.i2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//convert int to short
public class I2S extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int i = stack.popInt();
        short s = (short) i;
        stack.pushInt(s);
    }

}
