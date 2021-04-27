package com.struggle.jvm.instructions.comparisons.if_icmp;


import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.instructions.base.InstructionBranch;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;

public class IF_ICMPEQ extends InstructionBranch {

    @Override
    public void execute(StackFrame frame) {
        OperandStack stack = frame.getOperandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if (val1 == val2) {
            Instruction.branch(frame, this.offset);
        }
    }
    
}
