package com.ohgiraffers.Game;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.RuleRegistry;
import import com.ohgiraffers.Players.Player;
import com.ohgiraffers.Players.ScoreBoard;
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
                chooseCategory(player);
            }
            // 총 게임 결과 출력
            GameResult();
        }
    }

    private void chooseCategory(Player player){
        RuleRegistry ruleRegistry = RuleRegistry.ofDefaults();
        ScoreBoard board = player.getScoreBoard();

        // 1) 가능한 카테고리 목록(미기록 카테고리) 출력
        List<Category> candidates = board.getUnrecordedCategories();
        System.out.println("\n선택 가능한 카테고리:");
        System.out.println(Category.toMenu(candidates));

        // 2) 사용자 입력으로 카테고리 선택(유효성 검사 포함)
        Category chosen = null;
        while (true) {
            System.out.print("카테고리를 선택하세요(코드/이름): ");
            String input = sc.nextLine();
            Category parsed = Category.fromInput(input);
            if (parsed == null || !candidates.contains(parsed)) {
                System.out.println("잘못된 선택이거나 이미 기록된 카테고리입니다. 다시 입력하세요.");
                continue;
            }
            chosen = parsed;
            break;
        }

        // 3) 점수 계산
        int[] diceValues = player.getDiceSet().getValue();
        int score = ruleRegistry.score(chosen, diceValues);

        // 4) 점수 기록
        board.record(chosen, score);
        System.out.printf("%s(%s)에 %d점을 기록했습니다.%n", chosen.getKoreanName(), chosen.getDisplayName(), score);
    }

    private void GameResult() {
        //TODO: ScoreCard가 있다면 플레이어별 총점 정렬하여 우승자 출력
        System.out.println("(임시) 최종 결과 출력 로직은 추후 ScoreCard 연결 후 구현");
    }
}
