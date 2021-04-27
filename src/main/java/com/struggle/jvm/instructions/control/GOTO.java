package com.struggle.jvm.instructions.control;


import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.instructions.base.InstructionBranch;
import com.struggle.jvm.stack.StackFrame;

//branch always
public class GOTO extends InstructionBranch {

    @Override
    public void execute(StackFrame frame) {
        Instruction.branch(frame, this.offset);
    }
}
