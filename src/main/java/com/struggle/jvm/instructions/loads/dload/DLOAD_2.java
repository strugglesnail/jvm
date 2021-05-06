package com.struggle.jvm.instructions.loads.dload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;

public class DLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        double val = frame.getLocalVariable().getDouble(2);
        frame.getOperandStack().pushRef(val);
    }

}

