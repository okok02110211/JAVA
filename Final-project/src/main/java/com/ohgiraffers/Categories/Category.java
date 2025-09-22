package com.ohgiraffers.Categories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {

    // 상단 섹션
    ACES("Aces", "1", true, "에이스"),
    TWOS("Twos", "2", true, "투"),
    THREES("Threes", "3", true, "쓰리"),
    FOURS("Fours", "4", true, "포"),
    FIVES("Fives", "5", true, "파이브"),
    SIXES("Sixes", "6", true, "식스"),

    // 하단 섹션
    THREE_OF_A_KIND("Three of a Kind", "TOAK", false, "쓰리카인드"),
    FOUR_OF_A_KIND("Four of a Kind", "FOAK", false, "포카인드"),
    FULL_HOUSE("Full House", "FH", false, "풀하우스"),
    SMALL_STRAIGHT("Small Straight", "SS", false, "스몰 스트레이트"),
    LARGE_STRAIGHT("Large Straight", "LS", false, "라지 스트레이트"),
    YAHTZEE("Yahtzee", "Y", false, "야치"),
    CHANCE("Chance", "C", false, "찬스");

    private final String displayName;   // 영문 표기(설명)
    private final String code;          // 입력 코드(숏코드/숫자)
    private final boolean upperSection; // 상단 섹션 여부
    private final String koreanName;    // 한글 표시명

    Category(String displayName, String code, boolean upperSection, String koreanName) {
        this.displayName = displayName;
        this.code = code;
        this.upperSection = upperSection;
        this.koreanName = koreanName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCode() {
        return code;
    }

    public boolean isUpperSection() {
        return upperSection;
    }

    public String getKoreanName() {
        return koreanName;
    }

    // 사용자 입력을 카테고리로 매핑: 숫자, 코드, 이름 모두 지원
    public static Category fromInput(String input) {

        if (input == null) return null;
        String norm = input.trim().toUpperCase();

        // 코드 일치(예: "1", "TOAK", "C")
        for (Category c : values()) {
            if (c.code.equalsIgnoreCase(norm)) return c;
        }

        // 정식 이름(영문 enum 이름) 일치(예: "ACES", "YAHTZEE")
        for (Category c : values()) {
            if (c.name().equalsIgnoreCase(norm)) return c;
        }

        // 표시 이름(영문) 일부 포함, 혹은 한글명 포함 시 매칭 시도
        for (Category c : values()) {
            if (c.displayName.toUpperCase().contains(norm) ||
                    c.koreanName.toUpperCase().contains(norm)) {
                return c;
            }
        }
        return null;
    }

    // 선택지 메뉴 문자열(미사용 카테고리만 전달하면 UI 만들기 쉬움)
    public static String toMenu(List<Category> candidates) {
        List<Category> list = candidates == null || candidates.isEmpty()
                ? Arrays.asList(values())
                : candidates;
        return list.stream()
                .map(c -> String.format("[%s] %s / %s", c.code, c.koreanName, c.displayName))
                .collect(Collectors.joining("\n"));
    }
}