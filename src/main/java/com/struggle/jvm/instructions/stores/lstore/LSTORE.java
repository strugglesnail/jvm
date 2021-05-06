package com.struggle.jvm.instructions.stores.lstore;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.rtda.StackFrame;

public class LSTORE extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        _lstore(frame, this.idx);
    }

}
