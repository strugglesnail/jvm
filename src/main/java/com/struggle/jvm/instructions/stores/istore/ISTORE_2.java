package com.struggle.jvm.instructions.stores.istore;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class ISTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _istore(frame, 2);
    }

}
