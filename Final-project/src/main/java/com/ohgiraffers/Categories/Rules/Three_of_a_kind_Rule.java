package com.ohgiraffers.Categories.Rules;

import com.ohgiraffers.Categories.Category;
import com.ohgiraffers.Categories.ScoringRules;
import com.ohgiraffers.Utills.DiceUtills;

public class Three_of_a_kind_Rule implements ScoringRules {
    @Override
    public Category getCategory(){
        return Category.THREE_OF_A_KIND;
    }

    @Override
    public int getScore(int[] diceValues) {
        return DiceUtills.hasOfAKind(DiceUtills.counts(diceValues),3)? DiceUtills.sumAll(diceValues) : 0;
    }


}
