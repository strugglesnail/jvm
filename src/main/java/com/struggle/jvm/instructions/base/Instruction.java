package com.struggle.jvm.instructions.base;


import com.struggle.jvm.stack.StackFrame;

public interface Instruction {

    void fetchOperands(BytecodeReader reader);

    void execute(StackFrame frame);

    static void branch(StackFrame frame, int offset) {
        int pc = frame.thread().pc();
        int nextPC = pc + offset;
        frame.setNextPC(nextPC);
    }

}
