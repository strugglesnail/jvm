package com.struggle.jvm.instructions.constants.nop;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class NOP extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        //really do nothing
    }

}
