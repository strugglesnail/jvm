package com.struggle.jvm.instructions.loads.lload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class LLOAD_3 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        Long val = frame.getLocalVariable().getLong(3);
        frame.getOperandStack().pushLong(val);
    }

}
