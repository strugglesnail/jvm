package com.struggle.jvm.instructions.math.rem;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//remainder float
public class FREM extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        float res = v1 % v2;
        stack.pushFloat(res);
    }

}