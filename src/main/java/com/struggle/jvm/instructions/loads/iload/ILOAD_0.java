package com.struggle.jvm.instructions.loads.iload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class ILOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        int val = frame.getLocalVariable().getInt(0);
        frame.getOperandStack().pushInt(val);
    }
}

