package test.crossway;

import dssc.crossway.CrosswayGame;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void newGameTest() {
        CrosswayGame g = new CrosswayGame();
        g.start();
    }


}
