package com.struggle.jvm.instructions.loads.aload;


import com.struggle.jvm.instructions.base.InstructionNoOperands;
import com.struggle.jvm.rtda.StackFrame;
import com.struggle.jvm.rtda.heap.methodarea.Object;

public class ALOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(StackFrame frame) {
        Object ref = frame.getLocalVariable().getRef(1);
        frame.getOperandStack().pushRef(ref);
    }

}
