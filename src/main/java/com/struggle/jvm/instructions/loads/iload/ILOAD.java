package com.struggle.jvm.instructions.loads.iload;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.rtda.StackFrame;

//load int from local variable
public class ILOAD extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        int val = frame.getLocalVariable().getInt(this.idx);
        frame.getOperandStack().pushInt(val);
    }
}

