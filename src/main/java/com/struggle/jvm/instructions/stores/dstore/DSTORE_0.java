package com.struggle.jvm.instructions.stores.dstore;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class DSTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        _dstore(frame, 0);
    }

}
