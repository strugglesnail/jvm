package com.struggle.jvm.rtda;

import com.struggle.jvm.rtda.heap.methodarea.Object;

/**
 * @author strugglesnail
 * @date 2021/4/25
 * @desc 变量槽
 */
public class Slot {
    public int num;
    public Object ref;

    public int getNum() {
        return num;
    }

    public Object getRef() {
        return ref;
    }
}
