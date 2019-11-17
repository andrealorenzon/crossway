package test.crossway;

import dssc.crossway.*;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class GameControllerTest {


    @Test
    void boardIsValid(){
        GameController gc = initialize();
        assertTrue(gc.exists());
    }
    @Test
     void gameIsStarted(){
        GameController gc = initialize();
        gc.startGame();

    }

    @Test
     void firstMove() throws OutOfBoardException {
        GameController gc = initialize();
        gc.startGame();
        gc.placeStone(1,1, Colors.WHITE);
        assertEquals(gc.getCellStatus(1,1), Colors.WHITE);
    }

    private GameController initialize() {
        return new GameController(new GoBoard(12), new CrosswayRules());
    }

}
