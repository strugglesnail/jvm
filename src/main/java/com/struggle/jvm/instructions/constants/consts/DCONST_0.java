package com.struggle.jvm.instructions.constants.consts;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.StackFrame;

// push double
public class DCONST_0 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        frame.getOperandStack().pushDouble(0.0);
    }

}
