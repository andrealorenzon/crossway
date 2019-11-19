package test.crossway;

import dssc.crossway.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RulesTest {

    @Test
    void validateLegalMoveTest() throws OutOfBoardException {
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        Move m0 = new Move(1, 1, Colors.WHITE);
        assertTrue(gc.validateMove(m0));
    }

    @Test
    void validateIllegalMoveTest() throws OutOfBoardException, IllegalMoveException {
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        Move m0 = new Move(1, 1, Colors.WHITE);
        Move m1 = new Move(1, 1, Colors.BLACK);
        gc.placeStone(m0);
        assertFalse(gc.validateMove(m1));
    }

    @Test
    void crosswayIllegalMoveTestSoutheast() throws OutOfBoardException, IllegalMoveException {

        /**
         *     0 1 2
         *   0
         *   1   F E
         *   2   E i
         *
         */
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        try {
            gc.placeStone(new Move(1, 1, Colors.BLACK));
            gc.placeStone(new Move(1, 2, Colors.WHITE));
            gc.placeStone(new Move(2, 1, Colors.WHITE));

        } catch (Exception e) {
            System.out.println("Something wrong with the theoretically legal moves.");
        }

        Move m4 = new Move(2, 2, Colors.BLACK);
        assertFalse(gc.validateMove(m4));
    }

    @Test
    void crosswayIllegalMoveTestSouthwest() throws OutOfBoardException, IllegalMoveException {

        /**
         *     0 1 2
         *   0
         *   1   E F
         *   2   i E
         *
         */
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        try {
            gc.placeStone(new Move(2, 1, Colors.BLACK));
            gc.placeStone(new Move(2, 2, Colors.WHITE));
            gc.placeStone(new Move(1, 1, Colors.WHITE));

        } catch (Exception e) {
            System.out.println("Something wrong with the theoretically legal moves.");
        }

        Move m4 = new Move(1, 2, Colors.BLACK);
        assertFalse(gc.validateMove(m4));
    }

    @Test
    void crosswayIllegalMoveTestNorthwest() throws OutOfBoardException, IllegalMoveException {

        /**
         *     0 1 2
         *   0
         *   1   i E
         *   2   E F
         *
         */
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        try {
            gc.placeStone(new Move(2, 2, Colors.BLACK));
            gc.placeStone(new Move(1, 2, Colors.WHITE));
            gc.placeStone(new Move(2, 1, Colors.WHITE));

        } catch (Exception e) {
            System.out.println("Something wrong with the theoretically legal moves.");
        }

        Move m4 = new Move(1, 1, Colors.BLACK);
        assertFalse(gc.validateMove(m4));
    }

    @Test
    void crosswayIllegalMoveTestNorthEast() throws OutOfBoardException, IllegalMoveException {

        /**
         *     0 1 2
         *   0
         *   1   E i
         *   2   F E
         *
         */
        GameController gc = new GameController(new GoBoard(12), new CrosswayRules());
        gc.startGame();
        try {
            gc.placeStone(new Move(1, 2, Colors.BLACK));
            gc.placeStone(new Move(1, 1, Colors.WHITE));
            gc.placeStone(new Move(2, 2, Colors.WHITE));

        } catch (Exception e) {
            System.out.println("Something wrong with the theoretically legal moves.");
        }

        Move m4 = new Move(2, 1, Colors.BLACK);
        assertFalse(gc.validateMove(m4));
    }
}