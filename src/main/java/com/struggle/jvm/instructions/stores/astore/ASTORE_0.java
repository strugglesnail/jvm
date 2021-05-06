package com.struggle.jvm.instructions.stores.astore;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class ASTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _astore(frame, 0);
    }

}
