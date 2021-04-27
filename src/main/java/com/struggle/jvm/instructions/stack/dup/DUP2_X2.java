package com.struggle.jvm.instructions.stack.dup;

import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.Slot;
import com.struggle.jvm.stack.StackFrame;

// Duplicate the top one or two operand stack values and insert two, three, or four values down
/*
bottom -> top
[...][d][c][b][a]
       ____/ __/
      |   __/
      V  V
[...][b][a][d][c][b][a]
*/
public class DUP2_X2 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        Slot slot3 = stack.popSlot();
        Slot slot4 = stack.popSlot();
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
        stack.pushSlot(slot4);
        stack.pushSlot(slot3);
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
    }

}
