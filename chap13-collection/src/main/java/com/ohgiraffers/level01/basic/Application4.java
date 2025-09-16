package com.ohgiraffers.level01.basic;

import java.util.HashSet;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashSet<String> hs = new HashSet<>();
//        학생 ID 입력('exit' 입력 시 종료): hello
//        ID가 추가 되었습니다.
//                학생 ID 입력('exit' 입력 시 종료): java
//        ID가 추가 되었습니다.
//                학생 ID 입력('exit' 입력 시 종료): programmer
//        ID가 추가 되었습니다.
//                학생 ID 입력('exit' 입력 시 종료): java
//        이미 등록 된 ID입니다.
//        학생 ID 입력('exit' 입력 시 종료): exit
//        모든 학생의 ID : [java, programmer, hello]

        while(true){
            System.out.print("학생 ID 입력('exit' 입력 시 종료): ");
            sb.append(sc.nextLine());
            System.out.println("ID가 추가 되었습니다.");
            if(sb.toString().equals("exit")){
                System.out.print("모든 학생의 ID : " + hs);
                break;
            }else{
                hs.add(sb.toString());
            }
            sb.setLength(0);
        }




    }
}
