package com.struggle.jvm.instructions.math.or;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

//boolean or int
public class IOR extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int res = v1 | v2;
        stack.pushInt(res);
    }

}
