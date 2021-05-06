package com.struggle.jvm.instructions.loads.fload;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.rtda.StackFrame;

//load float from local variable
public class FLOAD extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        Float val = frame.getLocalVariable().getFloat(this.idx);
        frame.getOperandStack().pushFloat(val);
    }

}
