package com.struggle.jvm.instructions.loads.fload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class FLOAD_3 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        Float val = frame.getLocalVariable().getFloat(3);
        frame.getOperandStack().pushFloat(val);
    }

}
