package com.struggle.jvm.instructions.stack.pop;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;

// Pop the top operand rtda value
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
