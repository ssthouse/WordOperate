package com.ssthouse.control.util;

public class Log {
    public static void logInfo(String msg) {
        System.out.println("Info:    " + msg);
    }

    public static void logWarn(String msg) {
        System.out.println("Warn:    " + msg);
    }

    public static void log(String tag, String msg) {
        System.err.println(tag + ":    " + msg);
    }

    public static void log(String msg) {
        System.err.println("    " + msg);
    }
}
