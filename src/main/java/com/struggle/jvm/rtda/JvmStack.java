package com.struggle.jvm.rtda;

import java.util.Objects;

/**
 * @author strugglesnail
 * @date 2021/4/25
 * @desc 虚拟机栈
 */
public class JvmStack {

    // 存放最大的栈帧数
    private int maxSize;
    // 当前的栈帧数
    private int size;
    // 当前栈帧
    private StackFrame _top;

    // 自定义栈帧数的大小
    public JvmStack(int maxSize) {
        this.maxSize = maxSize;
    }

    // 栈帧入栈
    public void push(StackFrame stackFrame) {
        // 当前栈帧数超过最大栈帧数，则报错
        if (this.size > this.maxSize) {
            throw new StackOverflowError();
        }
        // 保存上一个栈帧到当前栈帧
        if (Objects.nonNull(this._top)) {
            stackFrame.lower = this._top;
        }
        this._top = stackFrame;
        this.size ++;
    }

    // 栈帧出栈
    public StackFrame pop() {
        if (this._top == null){
            throw new RuntimeException("jvm rtda is empty!");
        }
        StackFrame top = this._top;
        this._top = top.lower;
        this.size --;
        return top;
    }

    // 获取当前栈帧
    public StackFrame top(){
        if (this._top == null){
            throw new RuntimeException("jvm rtda is empty!");
        }
        return this._top;
    }
}
