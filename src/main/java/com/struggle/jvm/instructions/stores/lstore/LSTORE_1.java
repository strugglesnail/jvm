package com.struggle.jvm.instructions.stores.lstore;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class LSTORE_1 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _lstore(frame, 1);
    }

}
