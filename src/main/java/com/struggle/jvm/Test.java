package com.struggle.jvm;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author strugglesnail
 * @date 2021/4/15
 * @desc
 */
public class Test {

    final int  a = 1;
    int b = 1;

    public static void main(String[] args) throws UnsupportedEncodingException {
        int a = 4;
//        System.out.println(Runtime.getRuntime().availableProcessors() - 1);
//        int length = 4;
//        byte[] bytes = new byte[length];
//        bytes[0] = 97;
//        bytes[1] = 98;
//        bytes[2] = 99;
//        bytes[3] = 100;

//        byte[] data = new byte[]{ -54, -2, -70, -66 };
//        System.arraycopy(data, 0, bytes, 0, length);
//        System.arraycopy(data, length, data, 0, data.length - length);
//        System.out.println((0xCAFEBABE & 0x0FFFFFFFFL));
//        System.out.println("a1: "+new String(bytes, "UTF-8"));
//        System.out.println("a2: "+ byte2int(bytes));
//        System.out.println("a3: "+ Arrays.toString(data));
        String hello = "hello";
        System.out.println("* byte字节码与运算原值(-54)换行后(-54 & 0x0FF)：" + (-54 & 0x0FF));
//        System.out.println(Integer.toBinaryString(-54));
//        System.out.println(Integer.toBinaryString(255));
//        System.out.println(-54 & 255);
    }

    private static int byte2int(byte[] val) {
        String str_hex = new BigInteger(1, val).toString(16);
        return Integer.parseInt(str_hex, 16);
    }
}
