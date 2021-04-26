package com.struggle.jvm;

import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.parse.MemberInfo;
import com.struggle.jvm.parse.attributes.impl.CodeAttribute;
import com.struggle.jvm.stack.StackFrame;
import com.struggle.jvm.stack.Thread;

/**
 * @author strugglesnail
 * @date 2021/4/26
 * @desc 解析指令
 */
public class Interpret {

    public Interpret(MemberInfo memberInfo) {
        // 创建线程
        Thread thread = new Thread();
        // 获取栈帧信息
        CodeAttribute code = memberInfo.codeAttribute();
        int maxLocals = code.maxLocals(); // 最大的局部变量slot
        int maxStack = code.maxStack(); // 最大的操作数栈slot
        byte[] data = code.data();
        // 创建栈帧
        StackFrame stackFrame = thread.newFrame(maxLocals, maxStack);
        // 栈帧入栈（方法的调用）
        thread.pushFrame(stackFrame);
        // 栈帧出栈
        loop(thread, data);
    }

    private void loop(Thread thread, byte[] data) {
        // 创建字节解析器
        BytecodeReader reader = new BytecodeReader();
        // 当前栈帧
        StackFrame stackFrame = thread.popFrame();

        while (true) {
            // 定位字节
            reader.reset(data, thread.pc());
            // 获取指令偏移量
            byte b = reader.readByte();

        }

    }
}
