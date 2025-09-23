package com.ohgiraffers.Game;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.RuleRegistry;
import com.ohgiraffers.Players.Player;
import com.ohgiraffers.Players.ScoreBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class YahtzeeGame {
    private final List<Player> players = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    // 야치 표준 라운드 수: 카테고리 개수(13)
    private static final int TOTAL_ROUNDS = 13;
    // 플레이어 이름을 콘솔에서 입력받아 초기화(플레이어 리스트가 비어있을 때만)
    private void setupPlayersInteractive() {
        int count;
        while (true) {
            System.out.print("플레이어 수를 입력하세요(1 이상): ");
            String line = sc.nextLine().trim();
            try {
                count = Integer.parseInt(line);
                if (count >= 1) break;
            } catch (NumberFormatException ignored) {}
            System.out.println("유효한 숫자를 입력하세요.");
        }

        for (int i = 1; i <= count; i++) {
            String name;
            while (true) {
                System.out.printf("플레이어 %d의 이름을 입력하세요: ", i);
                name = sc.nextLine().trim();
                if (!name.isEmpty()) break;
                System.out.println("이름은 비어 있을 수 없습니다.");
            }
            players.add(new Player(name));
        }
    }

    public void run(){
        // 플레이어가 지정되지 않았다면 시작 시 입력받아 초기화
        if (players.isEmpty()) {
            System.out.println("===== 플레이어 설정 =====");
            setupPlayersInteractive();
        }

        System.out.println("===== 게임스타트 =====");
        for(int round = 1; round <= TOTAL_ROUNDS ; round++){
            System.out.println("===== "+round+"라운드 =====");
            for(Player player : players){
                System.out.println("\n=== " + player + "님의 턴" + " ===");
                Round roundObj = new Round(player);
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
        // 현재까지 기록된 점수 기준으로 리더보드 출력 및 1위(동점 포함) 안내
        if (players == null || players.isEmpty()) {
            System.out.println("플레이어가 없습니다.");
            return;
        }

        // 랭킹 정렬(총점 내림차순)
        List<Player> ranking = new ArrayList<>(players);
        ranking.sort(Comparator.comparingInt(p -> p.getScoreBoard().total()));
        ranking.sort(Comparator.comparingInt((Player p) -> p.getScoreBoard().total()).reversed());

        System.out.println("\n===== 현재 순위 =====");
        int rank = 0;
        Integer prevScore = null;
        int displayRank = 0;

        for (Player p : ranking) {
            int total = p.getScoreBoard().total();
            rank++;
            if (prevScore == null || total < prevScore) {
                displayRank = rank; // 동점이 아니면 순위 증가
                prevScore = total;
            }
            System.out.printf("%d위) %s - 총점 %d%n", displayRank, p, total);
        }

        // 우승 후보(최고 점수 동점 포함) 출력
        int topScore = ranking.get(0).getScoreBoard().total();
        List<Player> winners = new ArrayList<>();
        for (Player p : ranking) {
            if (p.getScoreBoard().total() == topScore) {
                winners.add(p);
            } else {
                break;
            }
        }

        if (winners.size() == 1) {
            System.out.printf("현재 1위: %s (총점 %d)%n", winners.get(0), topScore);
        } else {
            System.out.print("현재 공동 1위: ");
            for (int i = 0; i < winners.size(); i++) {
                System.out.print(winners.get(i));
                if (i < winners.size() - 1) System.out.print(", ");
            }
            System.out.printf(" (총점 %d)%n", topScore);
        }
    }
    public static void main(String[] args) {
        YahtzeeGame game = new YahtzeeGame();
        game.run();
    }
}
