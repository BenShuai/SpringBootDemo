package com.example.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnsyncTask {
    @Async
    public void Task1() throws Exception {
        System.out.println("1111111");
        Thread.sleep(1000);
        System.out.println("1111111");
        Thread.sleep(1000);
        System.out.println("1111111");
        Thread.sleep(1000);
        System.out.println("1111111");
        Thread.sleep(1000);
        System.out.println("1111111");
        Thread.sleep(1000);
        System.out.println("1111111");
        Thread.sleep(1000);
        System.out.println("1111111");
        Thread.sleep(1000);
        System.out.println("1111111");
        Thread.sleep(1000);
        System.out.println("1111111");
    }
    @Async
    public void Task2() throws Exception {
        System.out.println("2222222");
        Thread.sleep(1000);
        System.out.println("2222222");
        Thread.sleep(1000);
        System.out.println("2222222");
        Thread.sleep(1000);
        System.out.println("2222222");
        Thread.sleep(1000);
        System.out.println("2222222");
        Thread.sleep(1000);
        System.out.println("2222222");
        Thread.sleep(1000);
        System.out.println("2222222");
        Thread.sleep(1000);
        System.out.println("2222222");
        Thread.sleep(1000);
        System.out.println("2222222");
    }
    @Async
    public void Task3() throws Exception {
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
        Thread.sleep(1000);
        System.out.println("3333333");
    }
}
