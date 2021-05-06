package com.struggle.jvm.instructions.comparisons.dcmp;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class DCMPL extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _dcmp(frame, false);
    }

}