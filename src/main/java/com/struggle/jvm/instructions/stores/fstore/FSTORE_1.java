package com.struggle.jvm.instructions.stores.fstore;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class FSTORE_1 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _fstore(frame, 1);
    }

}