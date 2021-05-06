package com.struggle.jvm.instructions.base;


import com.struggle.jvm.rtda.StackFrame;

public class InstructionIndex16 implements Instruction {

    protected int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readShort();
    }

    @Override
    public void execute(StackFrame frame) {

    }
    
}
