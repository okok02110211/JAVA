package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class FivesRule implements ScoringRules {
    @Override
    public Category getCategory() {
        return Category.FIVES;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.sumOfFace(diceValues,5);
    }
}
