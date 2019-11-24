package test.crossway;

import dssc.crossway.*;
import org.junit.jupiter.api.Assertions;
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
     void firstMove() throws OutOfBoardException, IllegalMoveException {
        GameController gc = initialize();
        gc.startGame();
        gc.placeStone(1,1, Colors.WHITE);
        assertEquals(gc.getCellStatus(1,1), Colors.WHITE);
    }

    private GameController initialize() {
        return new GameController(new GoBoard(12), new CrosswayRules());
    }


     @Test
     void firstMove2() throws OutOfBoardException, IllegalMoveException {
         GameController gc = initialize();
         gc.startGame();
         Move m = new Move(1,1, Colors.WHITE);
         gc.placeStone(m);
         assertEquals(gc.getCellStatus(1,1), Colors.WHITE);
     }

     @Test
     void illegalMove() throws OutOfBoardException, IllegalMoveException {
         GameController gc = initialize();
         gc.startGame();
         Move m1 = new Move(1,1, Colors.WHITE);
         gc.placeStone(m1);
         Move m2 = new Move(1,1, Colors.WHITE);

         try {
             gc.placeStone(m2);
         } catch (IllegalMoveException e) {
             Assertions.assertEquals(e.getMessage(), "Illegal move!");
         }
     }


}
