package com.struggle.jvm.instructions.comparisons.if_acmp;


import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.instructions.base.InstructionBranch;
import com.struggle.jvm.rtda.StackFrame;

public class IF_ACMPNE extends InstructionBranch {

    @Override
    public void execute(StackFrame frame) {
        if (!_acmp(frame)) {
            Instruction.branch(frame, this.offset);
        }
    }

}