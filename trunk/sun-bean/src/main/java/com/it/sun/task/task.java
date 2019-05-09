package com.it.sun.task;

import com.it.common.task.quartz.QuartzManager;

/**
 * Quartz调度使用案例
 */
public class task {
    public static void main(String[] args) {
        QuartzManager.addJob("调度信息","com.it.demo.task.MyJob","10/2 * * * * ?");
        QuartzManager.addJob("调度信息22222222","com.it.demo.task.MyJob","10/2 * * * * ?");
    }
}
