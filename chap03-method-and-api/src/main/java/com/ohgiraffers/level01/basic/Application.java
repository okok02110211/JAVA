package com.ohgiraffers.level01.basic;
import java.util.Scanner;

public class Application {
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
}
