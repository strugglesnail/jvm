package com.struggle.jvm.stack;

/**
 * @author strugglesnail
 * @date 2021/4/25
 * @desc 局部变量表
 */
public class LocalVariable {

    // 变量槽
    private Slot[] slots;

    // 初始化变量槽
    public LocalVariable(int maxLocalsVars) {
        slots = new Slot[maxLocalsVars];
        for (int i = 0; i < maxLocalsVars; i++) {
            slots[i] = new Slot();
        }
    }

    // 入表
    public void setInt(int idx, int val) {
        this.slots[idx].num = val;
    }
    public int getInt(int idx) {
        return this.slots[idx].num;
    }
    public void setFloat(int idx, float val) {
        this.slots[idx].num = Float.valueOf(val).intValue();
    }
    public Float getFloat(int idx) {
        return (float)this.slots[idx].num;
    }

    public void setLong(int idx, long val) {
        this.slots[idx].num = (int) val;
        this.slots[idx + 1].num = (int) (val >> 32) ;
    }
    public long getLong(int idx) {
        int low = this.slots[idx].num;
        int high = this.slots[idx + 1].num;
        return ((long) high << 32) | (long) low;
    }

    public void setDouble(int idx, double val) {
        setLong(idx, (long) val);
    }
    public long getDouble(int idx) {
       return getLong(idx);
    }


    public void setRef(int idx, Object ref) {
        this.slots[idx].ref = ref;
    }

    public Object getRef(int idx) {
        return this.slots[idx].ref;
    }
}
