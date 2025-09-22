package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class TwosRule implements ScoringRules{
    @Override
    public Category getCategory() {
        return Category.TWOS;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.sumOfFace(DiceUtills.counts(diceValues),1);
    }
}
