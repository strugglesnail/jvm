package com.struggle.jvm.rtda;

/**
 * @author strugglesnail
 * @date 2021/4/25
 * @desc 变量槽
 */
public class Slot {
    int num;
    Object ref;

    public int getNum() {
        return num;
    }

    public Object getRef() {
        return ref;
    }
}
