package com.ohgiraffers.level01.basic;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.checkMethod();
        System.out.println("1 부터 10까지의 합 : " + cal.sum1to10());
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        cal.checkMaxNumber(a,b);

        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("10과 20 의 합은 : " + cal.sumTwoNumber(a, b));

        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("10과 5의 차는 : " + cal.minusTwoNumber(a, b));
    }
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
