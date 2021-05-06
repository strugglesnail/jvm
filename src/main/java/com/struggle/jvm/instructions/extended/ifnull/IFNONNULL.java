package com.struggle.jvm.instructions.extended.ifnull;


import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.instructions.base.InstructionBranch;
import com.struggle.jvm.rtda.StackFrame;

public class IFNONNULL extends InstructionBranch {

    @Override
    public void execute(StackFrame frame) {
        Object ref = frame.getOperandStack().popRef();
        if (null != ref) {
            Instruction.branch(frame, this.offset);
        }
    }
}