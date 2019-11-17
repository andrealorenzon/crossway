package test.crossway;

import dssc.crossway.GoBoard;
import dssc.crossway.OutOfBoardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GoBoardTest {


    @Test
    void getSideTest() {
        GoBoard board = new GoBoard (8);
        assertEquals(board.getSide(),8);
    }

    @Test
    void setCellStatusTest() throws OutOfBoardException {
        GoBoard board = new GoBoard (8);
        board.setCellStatus(1,4,"white");
        assertEquals(board.getCellStatus(1,4), "white");
    }

    @Test
    void testExceptionMessage() {

        GoBoard board = new GoBoard (8);
        try {
            board.setCellStatus(1,9, "bad");
        } catch (OutOfBoardException e) {
            assertEquals(e.getMessage(),"Out of board!");
        }
    }

    @Test
    void getCellStatusTest() {
        GoBoard board = new GoBoard(8);
        assertEquals(board.getCellStatus(1,4), "null");
    }


}
