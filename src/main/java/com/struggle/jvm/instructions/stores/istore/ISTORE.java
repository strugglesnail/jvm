package com.struggle.jvm.instructions.stores.istore;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.stack.StackFrame;

public class ISTORE extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        _istore(frame, this.idx);
    }

}