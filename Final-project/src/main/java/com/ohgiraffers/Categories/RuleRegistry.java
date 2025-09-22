package com.ohgiraffers.Categories;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.Rules.*;
import com.ohgiraffers.Categories.ScoringRules;

import java.util.EnumMap;
import java.util.Map;

public class RuleRegistry {
    private final Map<Category, ScoringRules> rules = new EnumMap<>(Category.class);

    // private 생성자: 외부에서 new 하지 않고 ofDefaults()로만 만들게 함
    private RuleRegistry() {
        // 기본 규칙 등록
        rules.put(Category.ACES, new AcesRule());
        rules.put(Category.TWOS, new TwosRule());
        rules.put(Category.THREES, new ThreesRule());
        rules.put(Category.FOURS, new FoursRule());
        rules.put(Category.FIVES, new FivesRule());
        rules.put(Category.SIXES, new SixesRule());

        rules.put(Category.THREE_OF_A_KIND, new Three_of_a_kind_Rule());
        rules.put(Category.FOUR_OF_A_KIND, new Four_of_a_kind_Rule());
        rules.put(Category.FULL_HOUSE, new Full_house_Rule());
        rules.put(Category.SMALL_STRAIGHT, new Small_straight_Rule());
        rules.put(Category.LARGE_STRAIGHT, new Large_straight_Rule());
        rules.put(Category.YAHTZEE, new Yahtzee_Rule());
        rules.put(Category.CHANCE, new Chance_Rule());
    }

    // 기본 인스턴스 제공
    public static RuleRegistry ofDefaults() {
        return new RuleRegistry();
    }

    // 점수 계산
    public int score(Category c, int[] dice) {
        ScoringRules rule = rules.get(c);
        if (rule == null) {
            throw new IllegalArgumentException("지원하지 않는 카테고리: " + c);
        }
        return rule.getScore(dice);
    }
}
