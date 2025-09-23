package com.ohgriaffers.Game;

import com.ohgiraffers.Game.YahtzeeGame;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YahtzeeGameTest {

    @Test
    void testRun_singlePlayer_noRerolls_completesAndPrints() {
        // 1라운드: reroll 안 하고, 카테고리 1(ACES) 선택
        String fakeInput = "n\n1\n";
        ByteArrayInputStream input = new ByteArrayInputStream(fakeInput.getBytes(StandardCharsets.UTF_8));

        List<String> names = Collections.singletonList("홍길동");
        YahtzeeGame game = new YahtzeeGame();

        // 출력 캡처
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            game.run();
        } finally {
            System.setOut(originalOut);
        }

        String out = outContent.toString();
        System.out.println(out); // 디버그용 출력

        assertTrue(out.contains("홍길동"));
        assertTrue(out.contains("에이스"));
    }





    @Test
    void testRun_twoPlayers_noRerolls_usesAllInputs() {
        // 입력 준비: 13라운드 × 플레이어 2명 → 각 턴 "n" 1줄씩, 총 26줄
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) sb.append("n\n");
        ByteArrayInputStream input = new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8));

        List<String> names = Arrays.asList("철수", "영희");
        YahtzeeGame game = new YahtzeeGame();

        // 출력 캡처
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        try {
            game.run();
        } finally {
            System.setOut(originalOut);
        }

        String out = outContent.toString();
        // 양쪽 플레이어의 턴 로그가 포함되는지 확인(간단 검증)
        System.out.println(out);

        assertTrue(out.contains("철수"));
        assertTrue(out.contains("영희"));
    }
}

