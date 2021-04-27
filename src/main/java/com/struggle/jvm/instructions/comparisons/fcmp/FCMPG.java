package com.struggle.jvm.instructions.comparisons.fcmp;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class FCMPG extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _fcmp(frame, true);
    }

}
