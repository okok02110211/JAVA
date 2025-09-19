package com.ohgiraffers.Dices;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();
    private int Value;

    public void roll(){
        this.Value = random.nextInt(6)+1;
    }

    public int getValue(){
        return Value;
    }
}
