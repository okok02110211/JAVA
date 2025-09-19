package com.ohgiraffers.Players;

import com.ohgiraffers.Dices.DiceSet;

public class Player {
    private final String name;
    private final DiceSet diceSet = new DiceSet();
    public Player(String name) {
        this.name = name;
    }

//    private final 보드
    public void takeTurns(){
        diceSet.rollAll();
        System.out.println(name + "의 주사위: " + diceSet);
    }


}
