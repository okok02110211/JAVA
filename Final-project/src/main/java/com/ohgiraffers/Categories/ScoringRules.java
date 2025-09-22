package com.ohgiraffers.Categories;

public interface ScoringRules {
    Category getCategory();
    int getScore(int[] diceValues);
}
