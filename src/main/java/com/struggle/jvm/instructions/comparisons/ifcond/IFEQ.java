package com.struggle.jvm.instructions.comparisons.ifcond;


import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.instructions.base.InstructionBranch;
import com.struggle.jvm.rtda.StackFrame;

public class IFEQ extends InstructionBranch {

    @Override
    public void execute(StackFrame frame) {
        int val = frame.getOperandStack().popInt();
        if (0 == val) {
            Instruction.branch(frame, this.offset);
        }
    }
}
