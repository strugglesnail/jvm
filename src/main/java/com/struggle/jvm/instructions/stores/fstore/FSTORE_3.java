package com.struggle.jvm.instructions.stores.fstore;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class FSTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _fstore(frame, 3);
    }

}