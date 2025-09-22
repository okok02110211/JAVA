package com.ohgiraffers.Players;

import com.ohgiraffers.Categories.Category;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final Player player;

    // 카테고리별 점수 기록
    private final EnumMap<Category, Integer> scores = new EnumMap<>(Category.class);
    // 이미 기록된 카테고리 집합(중복 기록 방지)
    private final EnumSet<Category> recorded = EnumSet.noneOf(Category.class);

    // 상단/하단 카테고리 그룹 정의
    private static final Set<Category> UPPER_SECTION = EnumSet.of(
            Category.ACES, Category.TWOS, Category.THREES,
            Category.FOURS, Category.FIVES, Category.SIXES
    );
    private static final Set<Category> LOWER_SECTION = EnumSet.of(
            Category.THREE_OF_A_KIND, Category.FOUR_OF_A_KIND, Category.FULL_HOUSE,
            Category.SMALL_STRAIGHT, Category.LARGE_STRAIGHT, Category.CHANCE, Category.YAHTZEE
    );

    // 상단 보너스 기준/점수(야치 표준)
    private static final int UPPER_BONUS_THRESHOLD = 63;
    private static final int UPPER_BONUS_SCORE = 35;

    public ScoreBoard(Player player) {
        this.player = Objects.requireNonNull(player, "플레이어는 반드시 존재해야합니다");
    }

    public Player getPlayer() {
        return player;
    }

    // 카테고리 기록 여부
    public boolean isRecorded(Category category) {
        requireCategory(category);
        return recorded.contains(category);
    }
    // 아직 기록되지 않은 카테고리 목록을 반환
    public List<Category> getUnrecordedCategories() {
        return Arrays.stream(Category.values())
                .filter(c -> !recorded.contains(c))
                .collect(Collectors.toList());
    }


    // 점수 조회(미기록이면 Optional.empty)
    public Optional<Integer> getScore(Category category) {
        requireCategory(category);
        return Optional.ofNullable(scores.get(category));
    }

    // 점수 기록(한 번만 가능)
    public void record(Category category, int score) {
        requireCategory(category);
        requireNonNegative(score);
        if (recorded.contains(category)) {
            throw new IllegalStateException("이미 기록된 카테고리입니다: " + category);
        }
        scores.put(category, score);
        recorded.add(category);
    }

    // 상단 합계
    public int upperTotal() {
        return sumOf(UPPER_SECTION);
    }

    // 상단 보너스(63점 이상 35점)
    public int upperBonus() {
        return upperTotal() >= UPPER_BONUS_THRESHOLD ? UPPER_BONUS_SCORE : 0;
    }

    // 하단 합계
    public int lowerTotal() {
        return sumOf(LOWER_SECTION);
    }

    // 총합
    public int total() {
        return upperTotal() + upperBonus() + lowerTotal();
    }

    // 현재 기록된 점수의 읽기 전용 뷰
    public Map<Category, Integer> viewScores() {
        return Collections.unmodifiableMap(scores);
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "player=" + player +
                ", upper=" + upperTotal() +
                ", bonus=" + upperBonus() +
                ", lower=" + lowerTotal() +
                ", total=" + total() +
                '}';
    }

    // 내부 유틸
    private int sumOf(Set<Category> categories) {
        int sum = 0;
        for (Category c : categories) {
            Integer v = scores.get(c);
            if (v != null) sum += v;
        }
        return sum;
    }

    private static void requireCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("카테고리는 없을수 없습니다");
        }
    }

    private static void requireNonNegative(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("점수는 음수가 될 수 없습니다: " + score);
        }
    }
}
