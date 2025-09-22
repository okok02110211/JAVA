package com.ohgiraffers.Players;

import com.ohgiraffers.Dices.DiceSet;

public class Player {
    private final String name;
    private final DiceSet diceSet = new DiceSet();
    private final ScoreBoard scoreBoard;


    public Player(String name) {
        this.name = name;
        this.scoreBoard = new ScoreBoard(this);

    }

    public DiceSet getDiceSet(){
        return diceSet;
    }

//    private final 보드
    public void Rolling(){
        diceSet.rollAll();
        System.out.println(name + "의 주사위: " + diceSet);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }


    public void reRolling(int... indices){
        diceSet.reroll(indices);
        System.out.println(name + "의 주사위: " + diceSet);
    }



}
