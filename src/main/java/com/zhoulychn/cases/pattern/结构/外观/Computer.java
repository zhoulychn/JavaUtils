package com.zhoulychn.cases.pattern.结构.外观;

/**
 * Created by lewis on 2017/2/26.
 */
public class Computer {

    private Cpu cpu = new Cpu();

    private Memory memory = new Memory();

    public void open() {
        System.out.println("computer opening");
        cpu.open();
        memory.open();
        System.out.println("computer opened");
    }

    public void close() {
        System.out.println("computer closing");
        cpu.close();
        memory.close();
        System.out.println("computer closed");
    }
}
