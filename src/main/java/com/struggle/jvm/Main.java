package com.struggle.jvm;

import com.struggle.jvm.load.Classpath;

import java.io.IOException;
import java.util.Arrays;

/**
 * @auther strugglesnail
 * @date 2021/4/14 23:43
 * @desc
 */
public class Main {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
//        System.out.println(cmd.ok + " " + cmd.helpFlag);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            //注意案例测试都是基于1.8，另外jdk1.9以后使用模块化没有rt.jar
            System.out.println("java version \"1.8.0\"");
            return;
        }
//        System.out.println(Arrays.toString(args) + cmd.classpath);
        Classpath classpath = new Classpath(cmd.jre, cmd.classpath);
        String className = cmd.getMainClass().replace(".", "/");
        byte[] bytes = classpath.readClass(className);
        try {
            for (byte b : bytes) {
                System.out.print(String.format("%02x", b & 0xff) + " ");
            }
        } catch (Exception e) {
            System.out.println("Could not find or load main class " + cmd.getMainClass());
            e.printStackTrace();
        }


    }
}
