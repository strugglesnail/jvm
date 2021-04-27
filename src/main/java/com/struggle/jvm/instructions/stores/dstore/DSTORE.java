package com.struggle.jvm.instructions.stores.dstore;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.stack.StackFrame;

public class DSTORE extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        _dstore(frame, this.idx);
    }

}
