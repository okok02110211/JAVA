package com.ohgiraffers.level02.normal;

public class Application {
    public static void main(String[] args) {
        RandomMaker randomMaker = new RandomMaker();
        System.out.println(randomMaker.randomNumber(5, 10));
        randomMaker.randomUpperAlpabet(8);
        System.out.println(randomMaker.rockPaperScissors());
        System.out.println(randomMaker.tossCoin());

    }
}
