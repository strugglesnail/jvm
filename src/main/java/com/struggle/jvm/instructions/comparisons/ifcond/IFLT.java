package com.struggle.jvm.instructions.comparisons.ifcond;


import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.instructions.base.InstructionBranch;
import com.struggle.jvm.rtda.StackFrame;

public class IFLT extends InstructionBranch {

    @Override
    public void execute(StackFrame frame) {
        int val = frame.getOperandStack().popInt();
        if (val < 0) {
            Instruction.branch(frame, this.offset);
        }
    }
}
