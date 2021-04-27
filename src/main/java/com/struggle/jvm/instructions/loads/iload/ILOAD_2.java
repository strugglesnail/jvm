package com.struggle.jvm.instructions.loads.iload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class ILOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        int val = frame.getLocalVariable().getInt(2);
        frame.getOperandStack().pushInt(val);
    }
}

