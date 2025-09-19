package com.ohgiraffers.Players;

import com.ohgiraffers.Dices.DiceSet;

public class Player {
    private final String name;
    private final DiceSet diceSet = new DiceSet();

    public Player(String name) {
        this.name = name;
    }

    public DiceSet getDiceSet(){
        return diceSet;
    }

//    private final 보드
    public void Rolling(){
        diceSet.rollAll();
        System.out.println(name + "의 주사위: " + diceSet);
    }

    public void reRolling(int... indices){
        diceSet.reroll(indices);
        System.out.println(name + "의 주사위: " + diceSet);
    }



}
