package com.struggle.jvm.instructions.math.and;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

// boolean and long
public class LAND extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        long res = v1 & v2;
        stack.pushLong(res);
    }

}
