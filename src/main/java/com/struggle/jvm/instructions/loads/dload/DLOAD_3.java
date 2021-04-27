package com.struggle.jvm.instructions.loads.dload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

public class DLOAD_3 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        double val = frame.getLocalVariable().getDouble(3);
        frame.getOperandStack().pushRef(val);
    }

}
