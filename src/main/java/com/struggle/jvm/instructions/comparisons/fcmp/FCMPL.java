package com.struggle.jvm.instructions.comparisons.fcmp;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class FCMPL extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _fcmp(frame, false);
    }

}
