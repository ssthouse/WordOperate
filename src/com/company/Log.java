package com.company;

public class Log {

    public static void logError(String msg) {
        System.out.println("Error:    " + msg);
    }

    public static void logInfo(String msg) {
        System.out.println("Info:    " + msg);
    }

    public static void logWarn(String msg) {
        System.out.println("Warn:    " + msg);
    }

    public static void log(String tag, String msg) {
        System.out.println(tag + ":    " + msg);
    }
}
