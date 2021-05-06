package com.struggle.jvm.instructions.constants.ipush;


import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.rtda.StackFrame;

//sipush指令从操作数中获取一个short型整数，扩展成int型，然后推入栈顶。
public class SIPUSH implements Instruction {

    private short val;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val = reader.readShort();
    }

    @Override
    public void execute(StackFrame frame) {
        frame.getOperandStack().pushInt(val);
    }
}
