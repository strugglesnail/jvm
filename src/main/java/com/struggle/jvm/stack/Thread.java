package com.struggle.jvm.stack;

/**
 * @author strugglesnail
 * @date 2021/4/25
 * @desc 线程
 */
public class Thread {

    // 程序计数器
    int pc;

    // 虚拟机栈
    private JvmStack jvmStack;

    // 初始化线程
    public Thread() {
        this.jvmStack = new JvmStack(1024);
    }

    public StackFrame newFrame(int maxLocals, int maxStack) {
        return new StackFrame(this, maxLocals, maxStack);
    }

    // 栈帧进栈
    public void pushFrame(StackFrame frame) {
        this.jvmStack.push(frame);
    }

    // 栈帧出栈
    public StackFrame popFrame() {
        return this.jvmStack.pop();
    }

    // 当前栈帧
    public StackFrame currentFrame() {
        return this.jvmStack.top();
    }

    public int pc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }
}
