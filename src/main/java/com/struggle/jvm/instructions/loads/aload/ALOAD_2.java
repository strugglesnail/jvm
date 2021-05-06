package com.struggle.jvm.instructions.loads.aload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class ALOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        Object ref = frame.getLocalVariable().getRef(2);
        frame.getOperandStack().pushRef(ref);
    }

}

