package com.struggle.jvm.instructions.loads.aload;


import com.struggle.jvm.instructions.base.InstructionIndex8;
import com.struggle.jvm.rtda.StackFrame;
import com.struggle.jvm.rtda.heap.methodarea.Object;

/**
 * @author strugglesnail
 * @date 2021/4/27 11:56
 * @desc 从局部变量表获取对象 到操作数栈
 */
public class ALOAD extends InstructionIndex8 {

    @Override
    public void execute(StackFrame frame) {
        Object ref = frame.getLocalVariable().getRef(this.idx);
        frame.getOperandStack().pushRef(ref);
    }

}
