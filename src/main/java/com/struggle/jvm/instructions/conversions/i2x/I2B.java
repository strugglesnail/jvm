package com.struggle.jvm.instructions.conversions.i2x;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//Convert int to byte
public class I2B extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int i = stack.popInt();
        int b = (byte) i;
        stack.pushInt(b);
    }

}
