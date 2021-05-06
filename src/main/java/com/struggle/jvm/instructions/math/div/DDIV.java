package com.struggle.jvm.instructions.math.div;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//divide double
public class DDIV extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        double res = v1 / v2;
        stack.pushDouble(res);
    }

}
