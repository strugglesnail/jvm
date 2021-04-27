package com.struggle.jvm.instructions.loads.iload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class ILOAD_3 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        int val = frame.getLocalVariable().getInt(3);
        frame.getOperandStack().pushInt(val);
    }
}

