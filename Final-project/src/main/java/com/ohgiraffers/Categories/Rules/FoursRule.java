package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class FoursRule implements ScoringRules {
    @Override
    public Category getCategory() {
        return Category.FOURS;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.sumOfFace(DiceUtills.counts(diceValues),4);
    }
}
