package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class Yahtzee_Rule implements ScoringRules {

    @Override
    public Category getCategory() {
        return Category.YAHTZEE;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.isYahtzee(DiceUtills.counts(diceValues))? 50 : 0;
    }
}
