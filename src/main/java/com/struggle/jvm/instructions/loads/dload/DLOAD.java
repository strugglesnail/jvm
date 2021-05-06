package com.struggle.jvm.instructions.loads.dload;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.rtda.StackFrame;

public class DLOAD extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        double val = frame.getLocalVariable().getDouble(this.idx);
        frame.getOperandStack().pushRef(val);
    }

}