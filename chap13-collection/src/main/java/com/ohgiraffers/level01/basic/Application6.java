package com.ohgiraffers.level01.basic;

import java.util.HashMap;
import java.util.Scanner;

public class Application6 {
    public static void main(String[] args) {
//        이름을 입력하면 전화번호를 검색할 수 있도록 전화번호부를 구현하세요.
        HashMap<String,String> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요  (검색하려면 'search', 종료하려면 'exit'): ");
            String input = sc.nextLine();
            String[] info = input.split("\\s+");
            if(info.length != 2){
                System.out.print("입력이 잘못 되었습니다. x다음 양식으로 입력해주세요 : <이름> <전화번호>");
            }else if(input.equals("search")){
                System.out.print("검색 할 이름 : ");
                input = sc.nextLine();// input 초기화 시켜도 상관없나?
                if(hm.containsKey(input)){
                    System.out.println(input + "씨의 전화번호 : " + hm.get(input));
                }else{
                    System.out.print(input + "씨의 번호는 등록 되어 있지 않습니다.");
                }
            }else if(input.equalsIgnoreCase("exit")) {
                break;
            }else{
                String name = info[0];
                String PhoneNum = info[1];
                hm.put(name,PhoneNum);
                System.out.print("추가 완료 : " + name + PhoneNum);
            }
        }

//        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 홍길동010-1234-5678
//        입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>
//                이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 홍길동 010-1234-5678
//        추가 완료 : 홍길동 010-1234-5678
//        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 유관순 010-9876-5432
//        추가 완료 : 유관순 010-9876-5432
//        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): search
//        검색 할 이름 : 유관순
//        유관순씨의 전화번호 : 010-9876-5432
//        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): search
//        검색 할 이름 : 이순신
//        이순신씨의 번호는 등록 되어 있지 않습니다.
//        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): exit
    }
}
