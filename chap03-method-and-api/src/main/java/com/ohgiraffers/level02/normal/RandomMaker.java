package com.ohgiraffers.level02.normal;

import java.util.Random;

public class RandomMaker {
    Random random = new Random();

    public int randomNumber(int min, int max) {
        return  random.nextInt(max - min) + min;
    }
    public void randomUpperAlpabet(int length){
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0 ; i < length ; i++){
            char a = (char) (random.nextInt(26) + 65);
            sb.append(a);
        }
        System.out.println(sb);
    }
    public String rockPaperScissors(){
        int random1 = (int)  (Math.random() * 3);
        String hand = "";
        if  (random1 == 0){
            hand = "가위";
        }
        else if (random1 == 1){
            hand = "바위";
        }
        else{
            hand = "보";
        }
        return hand;
    }
    public String tossCoin(){
        int random1 = (int) (Math.random() * 2);
        String Coin = "";
        if (random1 == 0){
            Coin = "앞면";
        }
        else{
            Coin = "뒷면";
        }
        return Coin;
    }
}
