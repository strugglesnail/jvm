package com.struggle.jvm.instructions.math.xor;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//boolean xor int
public class IXOR extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int v1 = stack.popInt();
        int v2 = stack.popInt();
        int res = v1 ^ v2;
        stack.pushInt(res);
    }

}
