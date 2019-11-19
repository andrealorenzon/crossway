package test.crossway;

import dssc.crossway.*;
import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RulesTest {

    @Test
    void validateMoveTest()
    {
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        Move m0 = new Move(1,1, Colors.WHITE);
        assertTrue(gc.validateMove(m0));
    }
}
