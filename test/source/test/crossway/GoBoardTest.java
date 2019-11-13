package test.crossway;

import dssc.crossway.GoBoard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GoBoardTest {

    // Test constructor and getSide
    @Test
    void ctorTest() {
        GoBoard board = new GoBoard(8);
        Assertions.assertEquals(board.getSide(),8);
    }

}
