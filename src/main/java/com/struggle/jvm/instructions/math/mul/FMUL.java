package com.struggle.jvm.instructions.math.mul;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//Multiply float
public class FMUL extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        float res = v1 * v2;
        stack.pushFloat(res);
    }

}
