package com.ohgiraffers.Dices;

import java.util.Arrays;

public class DiceSet {
    private final Dice[] dices;
    private static final int SIZE = 5;

    public DiceSet(){
        dices = new Dice[SIZE];
        for(int i = 0; i < SIZE ; i++){
            dices[i] = new Dice();
        }
    }

    public void rollAll(){
        for(Dice d : dices){
            d.roll();
        }
    }

    public void reroll(int... indices){
        for(int idx : indices){
            if(idx >= 0 && idx < SIZE){
                dices[idx].roll();
            }
        }
    }

    public int[] getValue(){
        int[] Values = new int[SIZE];
        for(int i = 0; i < SIZE; i++){
            Values[i] = dices[i].getValue();
        }
        return Values;
    }

    @Override
    public String toString(){
        return Arrays.toString(getValue());
    }

}
