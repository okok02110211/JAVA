package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class ThreesRule implements ScoringRules {
    @Override
    public Category getCategory() {
        return Category.THREES;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.sumOfFace(diceValues,3);
    }
}
