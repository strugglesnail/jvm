package com.struggle.jvm.instructions.base;


import com.struggle.jvm.rtda.StackFrame;

public class InstructionIndex8 implements Instruction {

    public int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readByte();
    }

    @Override
    public void execute(StackFrame frame) {

    }

    protected void _astore(StackFrame frame, int idx) {
        Object ref = frame.getOperandStack().popRef();
        frame.getLocalVariable().setRef(idx, ref);
    }

    protected void _dstore(StackFrame frame, int idx) {
        double val = frame.getOperandStack().popDouble();
        frame.getLocalVariable().setDouble(idx, val);
    }

    protected void _fstore(StackFrame frame, int idx) {
        float val = frame.getOperandStack().popFloat();
        frame.getLocalVariable().setFloat(idx, val);
    }

    protected void _istore(StackFrame frame, int idx) {
        int val = frame.getOperandStack().popInt();
        frame.getLocalVariable().setInt(idx, val);
    }

    protected void _lstore(StackFrame frame, int idx) {
        long val = frame.getOperandStack().popLong();
        frame.getLocalVariable().setLong(idx, val);
    }

}
