package com.struggle.jvm.instructions.stack.pop;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

// Pop the top operand stack value
/*
bottom -> top
[...][c][b][a]
            |
            V
[...][c][b]
*/
public class POP extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        stack.popSlot();
    }

}
