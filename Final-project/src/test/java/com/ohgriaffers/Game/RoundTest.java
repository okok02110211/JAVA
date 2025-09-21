package com.ohgriaffers.Game;

import com.ohgiraffers.Game.Round;
import com.ohgiraffers.Players.Player;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

class RoundTest {
    @Test
    void testTakeTurn() {
        // 사용자 입력을 흉내내는 문자열 준비 (엔터 포함)
        String input = "y\n1 3 5\nn\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Player player = new Player("홍길동");
        Round round = new Round(player, sc);

        round.Proceed();
    }
}
