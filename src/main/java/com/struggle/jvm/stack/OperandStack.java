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

    public void pushFloat(float val) {
        this.slots[this.size].num = (int) val;
        this.size++;
    }

    public float popFloat() {
        this.size--;
        return this.slots[this.size].num;
    }

    public void pushLong(long val) {
        this.slots[this.size].num = (int) val;
        this.slots[this.size + 1].num = (int) (val >> 32);
        this.size += 2;
    }

    public long popLong() {
        this.size -= 2;
        int low = this.slots[this.size].num;
        int high = this.slots[this.size + 1].num;
        return (long) (high) << 32 | (long) (low);
    }

    public void pushDouble(double val) {
        this.pushLong((long) val);
    }

    public double popDouble() {
        return this.popLong();
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

    public void pushSlot(Slot slot) {
        this.slots[this.size] = slot;
        this.size++;
    }

    public Slot popSlot(){
        this.size --;
        return this.slots[this.size];
    }

    public Slot[] getSlots() {
        return slots;
    }
}
