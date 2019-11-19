package test.crossway;

import dssc.crossway.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RulesTest {

    @Test
    void validateLegalMoveTest()
    {
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        Move m0 = new Move(1,1, Colors.WHITE);
        assertTrue(gc.validateMove(m0));
    }

    @Test
    void validateIllegalMoveTest() throws OutOfBoardException {
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        Move m0 = new Move(1,1, Colors.WHITE);
        Move m1 = new Move(1,1, Colors.BLACK);
        gc.placeStone(m0);
        assertFalse(gc.validateMove(m1));
    }
}
