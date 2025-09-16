package com.ohgiraffers.level01.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
//        학생들의 점수를 입력받아 저장한 후, 평균 점수를 계산하여 출력하는 프로그램을 작성하세요
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int score;
        char choice;
        do{
            System.out.print("학생 성적 : ");
            score = sc.nextInt();
            System.out.print("추가 입력하려면 y : ");
            choice = sc.next().charAt(0);
            list.add(score);
        }while(Character.toLowerCase(choice) == 'y');
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        System.out.print("학생 인원 : "+ list.size());
        System.out.print("평균 점수 : "+ (double)(sum/list.size()));



//        학생 성적 : 100
//        추가 입력하려면 y : y
//        학생 성적 : 95
//        추가 입력하려면 y : Y
//        학생 성적 : 66
//        추가 입력하려면 y : y
//        학생 성적 : 79
//        추가 입력하려면 y : n
//        학생 인원 : 4
//        평균 점수 : 85.0
    }
}