package com.struggle.jvm.instructions.extended;


import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.stack.StackFrame;

//branch always(wide index)
public class GOTO_W implements Instruction {

    private int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readInt();
    }

    @Override
    public void execute(StackFrame frame) {
        Instruction.branch(frame, this.offset);
    }

}
