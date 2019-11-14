package test.crossway;

import dssc.crossway.GoBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GoBoardTest {

    // Test constructor and getSide
    @Test
    void getSideTest() {
        GoBoard board = new GoBoard(8);
        assertEquals(board.getSide(),8);
    }

    @Test
    void getCellStatusTest() {
        GoBoard board = new GoBoard(8);
        assertEquals(board.getCellStatus(1,4), 0);
    }

    /*
    @Test
    void setCellStatus() {
        GoBoard board = new GoBoard(8);
        board.setCellStatus("A1","white");
        assertEquals(board.getCellStatus(1,4), 0);
    }
     */
}
