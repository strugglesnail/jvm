package com.struggle.jvm.instructions.constants.consts;

import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class LCONST_1 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        frame.getOperandStack().pushLong(1);
    }
}
