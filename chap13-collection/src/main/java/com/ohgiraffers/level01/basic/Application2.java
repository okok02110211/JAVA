package com.ohgiraffers.level01.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Application2 {
    public static void main(String[] args) {
//        사용자가 방문한 웹사이트 URL을 입력받아 저장하고, 가장 최근에 방문한 5개의 URL을 출력하는 프로그램을 작성하세요.
        Scanner sc = new Scanner(System.in);
        Stack<String> Url = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(true){
            sb.setLength(0);
            System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) : ");
            sb.append(sc.nextLine());
            if(sb.toString().equals("exit")){
                break;
            }
            Url.push(sb.toString());
            System.out.println("최근 방문 url : ");
            System.out.print("[");
            int start = Math.max(0, Url.size() - 5);
            for(int i = Url.size() - 1; i >= start; i--){
                if(i != Url.size() - 1) System.out.print(", ");
                System.out.print(Url.get(i));
            }
            System.out.println("]");


        }


//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
//        최근 방문 url : [https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
//        최근 방문 url : [https://github.com/, https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.notion.so/
//        최근 방문 url : [https://www.notion.so/, https://github.com/, https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.naver.com/
//        최근 방문 url : [https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
//        최근 방문 url : [https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
//        최근 방문 url : [https://www.google.com/, https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : exit



    }
}
