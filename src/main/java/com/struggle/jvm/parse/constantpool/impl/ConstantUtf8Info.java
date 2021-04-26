package com.struggle.jvm.parse.constantpool.impl;

import com.struggle.jvm.parse.ClassReader;
import com.struggle.jvm.parse.constantpool.ConstantInfo;

/**
 * @author strugglesnail
 * @date 2021/4/19
 * @desc 指向UTF-8编码的字符串
 */
public class ConstantUtf8Info implements ConstantInfo {

    // 长度为u2的UTF-8编码字符串
    private String str;

    @Override
    public void readInfo(ClassReader reader) {
        // u2：2个字节长度
        int length = reader.readUint16();

        byte[] bytes = reader.readBytes(length);
        // 2个字节长度的字符串
        this.str = new String(bytes);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_UTF8;
    }

    public String str(){
        return this.str;
    }


}
