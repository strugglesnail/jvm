package com.struggle.jvm.stack;

/**
 * @author strugglesnail
 * @date 2021/4/25
 * @desc 操作数栈
 */
public class OperandStack {
    // 当前栈的位置下标
    private int size;
    // 变量槽
    private Slot[] slots;

    // 初始化变量槽
    public OperandStack(int maxStack) {
        if (maxStack > 0) {
            slots = new Slot[maxStack];
            for (int i = 0; i < maxStack; i++) {
                slots[i] = new Slot();
            }
        }
    }

    public void pushInt(int val) {
        this.slots[size].num = val;
        this.size ++;
    }

    public int popInt() {
        this.size --;
        return this.slots[size].num;
    }

    public void pushRef(Object ref) {
        this.slots[size].ref = ref;
        this.size ++;
    }

    public Object popRef() {
        this.size --;
        Object ref = this.slots[size].ref;
        this.slots[size].ref = null;
        return ref;
    }
}
