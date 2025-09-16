package com.ohgiraffers.level01.basic;

import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {
//        사용자로부터 입력받은 텍스트에서 단어의 빈도를 계산하고, 가장 자주 등장하는 단어를 출력하는 프로그램을
//        String과 StringBuilder를 활용하여 구현한다. 단, 영문자만 대소문자 구분 없이 취급한다.
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 입력 : ");
        String string = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(Character.isLetter(c)){
                Character ch = Character.toLowerCase(c);
                sb.append(ch);
            }else if(c == ' '){
                sb.append(" ");
            }else if(Character.isDigit(c)){
                sb.append(c);
            }else{
                sb.append("");
            }
        }


        String[] words = sb.toString().split(" ");
        StringBuilder temp = new StringBuilder();

        for(String word: words) {
            temp = word;
        }

        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : hello world Hello everyone! 안녕하세요 반갑습니다
         *
         * ----- 출력 예시 -----
         *
         * ===== 단어 빈도 =====
         * hello: 2
         * world: 1
         * everyone: 1
         * 가장 빈도 높은 단어 : hello (2 번)
         */

    }
}