package com.struggle.jvm.instructions.base;


import com.struggle.jvm.rtda.OperandStack;
import com.struggle.jvm.rtda.StackFrame;
import com.struggle.jvm.rtda.heap.methodarea.Object;

public class InstructionNoOperands implements Instruction {
    @Override
    public void fetchOperands(BytecodeReader reader) {
        //empty
    }

    @Override
    public void execute(StackFrame frame) {
        // nothing to do
    }

    protected void _dcmp(StackFrame frame, boolean gFlag) {
        OperandStack stack = frame.getOperandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        if (v1 > v2) {
            stack.pushInt(1);
            return;
        }
        if (v1 == v2) {
            stack.pushInt(0);
            return;
        }
        if (v1 < v2) {
            stack.pushInt(-1);
            return;
        }
        if (gFlag) {
            stack.pushInt(1);
            return;
        }
        stack.pushInt(-1);
    }

    protected void _fcmp(StackFrame frame, boolean gFlag) {
        OperandStack stack = frame.getOperandStack();
        double v2 = stack.popFloat();
        double v1 = stack.popFloat();
        if (v1 > v2) {
            stack.pushInt(1);
            return;
        }
        if (v1 == v2) {
            stack.pushInt(0);
            return;
        }
        if (v1 < v2) {
            stack.pushInt(-1);
            return;
        }
        if (gFlag) {
            stack.pushInt(1);
            return;
        }
        stack.pushInt(-1);
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
