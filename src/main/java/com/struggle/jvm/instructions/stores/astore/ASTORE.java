package com.struggle.jvm.instructions.stores.astore;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.stack.StackFrame;

//store reference into local variable
public class ASTORE extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        _astore(frame, this.idx);
    }

}
