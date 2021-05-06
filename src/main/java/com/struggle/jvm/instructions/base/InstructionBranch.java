package com.struggle.jvm.instructions.base;


import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;


public class InstructionBranch implements Instruction {

    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readShort();
    }

    @Override
    public void execute(StackFrame frame) {
    }

    protected boolean _acmp(StackFrame frame){
        OperandStack stack = frame.getOperandStack();
        Object ref2 = stack.popRef();
        Object ref1 = stack.popRef();
        return ref1.equals(ref2);
    }

}
