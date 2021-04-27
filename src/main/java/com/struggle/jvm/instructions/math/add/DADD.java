package com.struggle.jvm.instructions.math.add;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//add double
public class DADD extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double v1 = stack.popDouble();
        double v2 = stack.popDouble();
        double res = v1 + v2;
        stack.pushDouble(res);
    }

}
