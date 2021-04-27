package com.struggle.jvm.instructions.stack.pop;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

// Pop the top one or two operand stack values
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
