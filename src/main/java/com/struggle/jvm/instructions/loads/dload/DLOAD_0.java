package com.struggle.jvm.instructions.loads.dload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class DLOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        double val = frame.getLocalVariable().getDouble(0);
        frame.getOperandStack().pushRef(val);
    }

}