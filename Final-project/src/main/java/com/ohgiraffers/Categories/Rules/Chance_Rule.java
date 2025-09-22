package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class Chance_Rule implements ScoringRules {
    @Override
    public Category getCategory() {
        return Category.CHANCE;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.sumAll(diceValues);
    }
}
