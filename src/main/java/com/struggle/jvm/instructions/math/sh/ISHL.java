package com.struggle.jvm.instructions.math.sh;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

//shift left int
public class ISHL extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int s = v2 & 0x1f;
        int res = v1 << s;
        stack.pushInt(res);
    }

}
