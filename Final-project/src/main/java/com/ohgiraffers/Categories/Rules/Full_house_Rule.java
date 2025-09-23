package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class Full_house_Rule implements ScoringRules {
    @Override
    public Category getCategory() {
        return Category.FULL_HOUSE;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.isFullHouse(DiceUtills.counts(diceValues)) ? 25 : 0;
    }
}
