package com.ohgriaffers.Players;


import com.ohgiraffers.Players.Player;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void testTakeTurn() {
        Player player = new Player("홍길동");
        player.Rolling();  // 주사위 굴리고 결과 출력
    }
}
