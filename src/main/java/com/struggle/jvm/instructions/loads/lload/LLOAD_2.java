package com.struggle.jvm.instructions.loads.lload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class LLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        Long val = frame.getLocalVariable().getLong(2);
        frame.getOperandStack().pushLong(val);
    }

}
