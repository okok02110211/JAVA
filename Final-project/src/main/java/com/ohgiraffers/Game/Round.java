package com.ohgiraffers.Game;

import com.ohgiraffers.Players.Player;
import java.util.Scanner;

public class Round {
    private final Player player;
    private final Scanner sc;
//    private final Scanner sc = new Scanner(System.in);

    public Round(Player player,Scanner sc) {
        this.player = player;
        this.sc = sc;
    }

    public void Proceed(){
        System.out.println("======= 라운드 진행합니다 =======");
        player.Rolling();
        for(int rerollcount = 3; rerollcount > 0 ; rerollcount--){
            System.out.println("남은 리롤 횟수 : " + (rerollcount-1));
            System.out.println("주사위 다시굴리기 (Y/N) :");
            String input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("y")){
                System.out.println("다시 굴릴 주사위 번호(순서) 를 입력하세요. ex) 1 3 5:");
                String[] rerollIndex = sc.nextLine().split(" ");
                int[] parsedIndex = new int[rerollIndex.length];
                for(int i = 0 ; i < rerollIndex.length; i++){
                    try{
                        parsedIndex[i] = Integer.parseInt(rerollIndex[i]) - 1;
                    }catch(NumberFormatException e){
                        parsedIndex[i] = -1;
                    }
                }
                player.reRolling(parsedIndex);
            }else{
                break;
            }
            System.out.println();
        }
    }
}
