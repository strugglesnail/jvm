package com.struggle.jvm.stack;

/**
 * @author strugglesnail
 * @date 2021/4/25
 * @desc 栈帧
 */
public class StackFrame {

    // 所属线程
    Thread thread;

    int nextPC;

    StackFrame lower;

    // 局部变量表
    private LocalVariable localVariable;

    // 操作数栈
    private OperandStack operandStack;

    public StackFrame(Thread thread, int maxLocals, int maxStack) {
        this.thread = thread;
        this.localVariable = new LocalVariable(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVariable getLocalVariable() {
        return localVariable;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }

    public Thread thread() {
        return thread;
    }
}
