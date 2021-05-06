package com.struggle.jvm.instructions.loads.fload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class FLOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        Float val = frame.getLocalVariable().getFloat(1);
        frame.getOperandStack().pushFloat(val);
    }

}
