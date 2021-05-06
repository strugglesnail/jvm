package com.struggle.jvm.instructions.constants.ipush;


import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.rtda.StackFrame;

//bipush指令从操作数中获取一个byte型整数，扩展成int型，然后推入栈顶。
public class BIPUSH implements Instruction {

    private byte val;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val = reader.readByte();
    }

    @Override
    public void execute(StackFrame frame) {
        frame.getOperandStack().pushInt(val);
    }

}
