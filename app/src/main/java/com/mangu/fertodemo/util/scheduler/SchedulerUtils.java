package com.mangu.fertodemo.util.scheduler;


public class SchedulerUtils {

    public static <T> IoMainScheduler<T> ioToMain() {
        return new IoMainScheduler<>();
    }
}
