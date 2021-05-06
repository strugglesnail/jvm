package com.struggle.jvm.instructions.math.iinc;


import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.rtda.LocalVariable;
import com.struggle.jvm.rtda.StackFrame;

//increment local variable by constants
public class IINC implements Instruction {

    public int idx;
    public int constVal;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readByte();
        this.constVal = reader.readByte();
    }

    @Override
    public void execute(StackFrame frame) {
        LocalVariable vars = frame.getLocalVariable();
        int val = vars.getInt(this.idx);
        val += this.constVal;
        vars.setInt(this.idx, val);
    }
}
