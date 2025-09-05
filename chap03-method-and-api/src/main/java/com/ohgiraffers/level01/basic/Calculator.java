package com.ohgiraffers.level01.basic;

public class Calculator {
    public void checkMethod(){
    System.out.println("메소드 호출 확인 ");
    }
    public int sum1to10(){
    return (1+2+3+4+5+6+7+8+9+10);
    }
    public void checkMaxNumber(int a, int b){
    System.out.println("두 수 중 큰 수는 20이다 : " + Math.max(a,b));
    }
    public int sumTwoNumber(int a, int b){
    return a+b;
    }
    public int minusTwoNumber(int a, int b){
    return a-b;
    }
}
