package com.struggle.jvm.instructions.stack.dup;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.Slot;
import com.struggle.jvm.stack.StackFrame;

//duplicate the lop operand stack value
/*
bottom -> top
[...][c][b][a]
             \_
               |
               V
[...][c][b][a][a]
*/
public class DUP extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        Slot slot = stack.popSlot();
        stack.pushSlot(slot);
        stack.pushSlot(slot);
    }

}
