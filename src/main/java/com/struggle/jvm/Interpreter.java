package com.struggle.jvm;

import com.alibaba.fastjson.JSON;
import com.struggle.jvm.instructions.Factory;
import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.parse.MemberInfo;
import com.struggle.jvm.parse.attributes.impl.CodeAttribute;
import com.struggle.jvm.stack.LocalVariable;
import com.struggle.jvm.stack.OperandStack;
import com.struggle.jvm.stack.StackFrame;
import com.struggle.jvm.stack.Thread;

/**
 * @author strugglesnail
 * @date 2021/4/26
 * @desc 解析指令
 */
public class Interpreter {

    public Interpreter(MemberInfo memberInfo) {
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
            // 定位指令码
            int nextPC = stackFrame.getNextPC();
            // 设置程序计数器
            thread.setPc(nextPC);
            // 定位字节
            reader.reset(data, thread.pc());
            // 获取指令偏移量
            byte opcode = reader.readByte();
            // 根据偏移量获取指令
            Instruction instruction = Factory.newInstruction(opcode);
            if (instruction == null) {
                System.out.println("程序计数器(指令)尚未实现 " + byteToHexString(new byte[]{opcode}));
                break;
            }
            // 偏移量
            instruction.fetchOperands(reader);
            stackFrame.setNextPC(reader.pc());
            System.out.println("寄存器(指令)：" + byteToHexString(new byte[]{opcode}) + " -> " + instruction.getClass().getSimpleName() + " => 局部变量表：" + JSON.toJSONString(stackFrame.getLocalVariable().getSlots()) + " 操作数栈：" + JSON.toJSONString(stackFrame.getOperandStack().getSlots()));            //exec

            // 执行指令码
            instruction.execute(stackFrame);
        }

    }

    private static String byteToHexString(byte[] codes) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        for (byte b : codes) {
            int value = b & 0xFF;
            String strHex = Integer.toHexString(value);
            if (strHex.length() < 2) {
                strHex = "0" + strHex;
            }
            sb.append(strHex);
        }
        return sb.toString();
    }
}
