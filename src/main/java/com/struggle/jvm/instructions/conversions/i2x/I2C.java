package com.struggle.jvm.instructions.conversions.i2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//convert int to char
public class I2C extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int i = stack.popInt();
        int c = (short) i;
        stack.pushInt(c);
    }

}