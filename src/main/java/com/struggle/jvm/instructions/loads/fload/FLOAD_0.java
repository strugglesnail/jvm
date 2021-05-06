package com.struggle.jvm.instructions.loads.fload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class FLOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        Float val = frame.getLocalVariable().getFloat(0);
        frame.getOperandStack().pushFloat(val);
    }

}
