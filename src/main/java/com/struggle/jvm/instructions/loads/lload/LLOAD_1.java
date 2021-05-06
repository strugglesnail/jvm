package com.struggle.jvm.instructions.loads.lload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class LLOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        Long val = frame.getLocalVariable().getLong(1);
        frame.getOperandStack().pushLong(val);
    }

}
