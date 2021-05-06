package com.struggle.jvm.instructions.constants.consts;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class ICONST_2 extends InstructionNoOperands {
    @Override
    public void execute(StackFrame frame) {
        frame.getOperandStack().pushInt(2);
    }
}
