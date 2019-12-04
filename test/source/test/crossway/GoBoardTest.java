package test.crossway;

import dssc.crossway.Colors;
import dssc.crossway.GoBoard;
import dssc.crossway.OutOfBoardException;
import org.junit.jupiter.api.Test;

import static   org.junit.jupiter.api.Assertions.assertEquals;


 class GoBoardTest {


    @Test
    void getSideTest() {
        GoBoard board = new GoBoard (8);
        assertEquals(board.getSide(),8);
    }

    @Test
    void setCellStatusTest() throws OutOfBoardException {
        GoBoard board = new GoBoard(8);
        board.setCellStatus(1,4, Colors.WHITE);
        assertEquals(board.getCellStatus(1,4), Colors.WHITE);
    }

     @Test
     void getCellStatusTest() throws OutOfBoardException {
         GoBoard board = new GoBoard(8);
         assertEquals(board.getCellStatus(1,4), Colors.EMPTY);
     }

    @Test
    void testExceptionMessage() {

        GoBoard board = new GoBoard (8);
        try {
            board.setCellStatus(1,9, Colors.WHITE);
        } catch (OutOfBoardException e) {
            assertEquals(e.getMessage(),"Out of board!");
        }
    }

     @Test
     void testToString() {

         GoBoard board = new GoBoard (12);
         try {
             board.setCellStatus(1,9, Colors.WHITE);
             board.setCellStatus(0,2, Colors.WHITE);
             board.setCellStatus(7,4, Colors.BLACK);
             board.setCellStatus(5,11, Colors.BLACK);
             board.setCellStatus(5,7, Colors.BLACK);
         } catch (OutOfBoardException e) {
             assertEquals(e.getMessage(),"Out of board!");
         }

         String expected =                  //y
                         "............accapo" + //0
                         "............accapo" + //1
                         "W...........accapo" + //2
                         "............accapo" + //3
                         ".......B....accapo" + //4
                         "............accapo" + //5
                         "............accapo" + //6
                         ".....B......accapo" + //7
                         "............accapo" + //8
                         ".W..........accapo" + //9
                         "............accapo" + //10
                         ".....B......accapo";    //11
                     //x: 0123456789te

         assertEquals(expected,board.toString());
     }




}
