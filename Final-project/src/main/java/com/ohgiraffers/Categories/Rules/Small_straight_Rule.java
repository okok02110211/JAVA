package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class Small_straight_Rule implements ScoringRules {
    @Override
    public Category getCategory() {
        return Category.SMALL_STRAIGHT;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.hasStraight(DiceUtills.counts(diceValues),5)? 30 : 0;
    }
}
