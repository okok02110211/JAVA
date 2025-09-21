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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YahtzeeGameTest {

    @Test
    void testRun_singlePlayer_noRerolls_completesAndPrints() {
        // 입력 준비: 13라운드 × 플레이어 1명 → 각 턴마다 "n" 1줄씩, 총 13줄
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) sb.append("n\n");
        ByteArrayInputStream input = new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8));

        List<String> names = Collections.singletonList("홍길동");
        YahtzeeGame game = new YahtzeeGame(names, new java.util.Scanner(input));

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
        assertTrue(out.contains("===== 게임스타트 ====="));
        assertTrue(out.contains("(임시) 카테고리 선택/기록 로직은 추후 ScoreCard/Scorer 연결 예정"));
        assertTrue(out.contains("(임시) 최종 결과 출력 로직은 추후 ScoreCard 연결 후 구현"));
    }


    @Test
    void testRun_twoPlayers_noRerolls_usesAllInputs() {
        // 입력 준비: 13라운드 × 플레이어 2명 → 각 턴 "n" 1줄씩, 총 26줄
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) sb.append("n\n");
        ByteArrayInputStream input = new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8));

        List<String> names = Arrays.asList("철수", "영희");
        YahtzeeGame game = new YahtzeeGame(names, new java.util.Scanner(input));

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

