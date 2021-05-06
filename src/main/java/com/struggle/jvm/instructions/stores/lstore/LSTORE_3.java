package com.struggle.jvm.instructions.stores.lstore;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class LSTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _lstore(frame, 3);
    }

}
