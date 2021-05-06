package com.struggle.jvm.instructions.stack.dup;

import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.Slot;
import com.struggle.jvm.rtda.StackFrame;


// Duplicate the top one or two operand rtda values and insert two or three values down
/*
bottom -> top
[...][c][b][a]
       _/ __/
      |  |
      V  V
[...][b][a][c][b][a]
*/
public class DUP2_X1 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        Slot slot3 = stack.popSlot();
         stack.pushSlot(slot2);
         stack.pushSlot(slot1);
         stack.pushSlot(slot3);
         stack.pushSlot(slot2);
         stack.pushSlot(slot1);
    }

}
