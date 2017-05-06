package com.zhoulychn.cases.pattern.结构.代理;

/**
 * Created by lewis on 2017/2/26.
 */
public class ChipDecorator implements Executable {

    private Chip chip = null;

    ChipDecorator(Chip chip) {
        this.chip = chip;
    }

    @Override
    public void execute() {
        System.out.println("start");
        chip.execute();
        System.out.println("end");
    }
}
