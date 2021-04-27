package com.struggle.jvm.instructions.math.div;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//divide int
public class IDIV extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        if (v2 == 0){
            throw new ArithmeticException("/ by zero");
        }
        int res = v1 / v2;
        stack.pushInt(res);
    }

}
