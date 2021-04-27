package com.struggle.jvm.instructions.loads.lload;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.stack.StackFrame;

public class LLOAD extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        Long val = frame.getLocalVariable().getLong(this.idx);
        frame.getOperandStack().pushLong(val);
    }

}
