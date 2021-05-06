package com.struggle.jvm.instructions.stack.pop;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

// Pop the top one or two operand rtda values
/*
bottom -> top
[...][c][b][a]
         |  |
         V  V
[...][c]
*/
public class POP2 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        stack.popSlot();
        stack.popSlot();
    }

}
