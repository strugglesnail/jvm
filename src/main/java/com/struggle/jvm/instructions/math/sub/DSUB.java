package com.struggle.jvm.instructions.math.sub;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//subtract double
public class DSUB extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        double res = v1 - v2;
        stack.pushDouble(res);
    }

}
