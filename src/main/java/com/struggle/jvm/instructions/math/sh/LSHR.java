package com.struggle.jvm.instructions.math.sh;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

// Arithmetic shift right long
public class LSHR  extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        long v1 = stack.popLong();
        long s = v2 & 0x3f;
        long res = v1 >> s;
        stack.pushLong(res);
    }

}

