package com.ohgiraffers.Game;

import com.ohgiraffers.Players.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YahtzeeGame {
    private final List<Player> players;
    private final Scanner sc;
    // 야치 표준 라운드 수: 카테고리 개수(13)
    private static final int TOTAL_ROUNDS = 13;

    public YahtzeeGame(List<String> playerNames, Scanner sc) {
        this.sc = sc;
        this.players = new ArrayList<>();
        for (String name : playerNames) {
            this.players.add(new Player(name));
        }
    }

    public void run(){
        System.out.println("===== 게임스타트 =====");
        for(int round = 1; round <= TOTAL_ROUNDS ; round++){
            System.out.println("=====번째 게임스타트 =====");
            for(Player player : players){
                System.out.println("\n=== " + player + "님의 턴" + " ===");
                Round roundObj = new Round(player, sc);
                roundObj.Proceed();
                // 다이스 세트를 통해 카테고리 선택
                chooseCartegory();
            }
            // 총 게임 결과 출력
            GameResult();
        }
    }

    private void chooseCartegory(){
        // TODO: 점수판 연동 전 임시 처리
        // 1) 가능한 카테고리 목록 출력 (ScoreCard가 있다면 아직 미사용 카테고리만)
        // 2) 사용자 입력으로 카테고리 선택
        // 3) Scorer를 이용해 player.getDiceSet().getValue()로 점수 계산
        // 4) ScoreCard에 기록
        System.out.println("(임시) 카테고리 선택/기록 로직은 추후 ScoreCard/Scorer 연결 예정\n");
    }

    private void GameResult() {
        // TODO: ScoreCard가 있다면 플레이어별 총점 정렬하여 우승자 출력
        System.out.println("(임시) 최종 결과 출력 로직은 추후 ScoreCard 연결 후 구현");
    }


}
