
package com.ohgiraffers.Utills;

import java.util.Arrays;

public class DiceUtills {
    public static int[] counts(int[] dice) {
        int[] c = new int[7];
        for (int d : dice) c[d]++;
        return c;
    }

    public static int sumAll(int[] dice) {
        return Arrays.stream(dice).sum();
    }

    public static int sumOfFace(int[] dice, int face) {
        return (int) Arrays.stream(dice).filter(d -> d == face).count() * face;
    }

    public static boolean hasOfAKind(int[] counts, int n) {
        for (int i = 1; i <= 6; i++) if (counts[i] >= n) return true;
        return false;
    }

    public static boolean isFullHouse(int[] counts) {
        boolean has3 = false, has2 = false;
        for (int i = 1; i <= 6; i++) {
            if (counts[i] == 3) has3 = true;
            if (counts[i] == 2) has2 = true;
        }
        return has3 && has2;
    }

    public static boolean hasStraight(int[] counts, int need) {
        int best = 0, cur = 0;
        for (int i = 1; i <= 6; i++) {
            if (counts[i] >= 1) {
                cur++;
                best = Math.max(best, cur);
            } else {
                cur = 0;
            }
        }
        return best >= need;
    }

    public static boolean isYahtzee(int[] counts) {
        for (int i = 1; i <= 6; i++) if (counts[i] == 5) return true;
        return false;
    }
}
