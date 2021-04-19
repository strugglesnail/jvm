package com.struggle.jvm;

import java.io.UnsupportedEncodingException;

/**
 * @author strugglesnail
 * @date 2021/4/15
 * @desc
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(Runtime.getRuntime().availableProcessors() - 1);
        byte[] bytes = new byte[4];
        bytes[0] = 97;
        bytes[1] = 98;
        bytes[2] = 99;
        bytes[3] = 100;
        System.out.println("a: "+new String(bytes, "UTF-8"));
    }
}
