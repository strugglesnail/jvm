package com.struggle.jvm.instructions.math.rem;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//remainder long
public class LREM extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if (v2 == 0){
            throw new ArithmeticException("/ by zero");
        }
        long res = v1 % v2;
        stack.pushLong(res);
    }

}
