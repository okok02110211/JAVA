package com.ohgiraffers.level01.basic;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Application5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        while(true){
            System.out.println("단어 입력 ('exit' 입력 시 종료): ");
            sb.append(sc.nextLine());
            if(sb.toString().equals("exit")){
                break;
            }else{
                treeSet.add(sb.toString());
            }
            sb.setLength(0);
        }
        System.out.println("정렬 된 단어 : " + treeSet);
//        단어 입력 ('exit' 입력 시 종료): 안녕
//        단어 입력 ('exit' 입력 시 종료): java
//        단어 입력 ('exit' 입력 시 종료): collection
//        단어 입력 ('exit' 입력 시 종료): 프로그래밍
//        단어 입력 ('exit' 입력 시 종료): exit
//        정렬 된 단어 : [collection, java, 안녕, 프로그래밍]
    }
}
