package com.struggle.jvm.instructions.stores.fstore;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.stack.StackFrame;

public class FSTORE extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        _fstore(frame, this.idx);
    }

}
