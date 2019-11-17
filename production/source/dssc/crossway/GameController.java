package dssc.crossway;

public class GameController {

    /**
     *  Class that encodes the methods to carry on the game
     *
     *
     */

    private GoBoard board;
    private  Validator rules;



    public GameController(GoBoard board,Validator rules) {
        this.board = board;
        this.rules = rules;
    }

    public boolean exists() {
        return true;
    }

    public void startGame() {

    }

    public void placeStone(int x, int y, Colors color) throws OutOfBoardException {
        board.setCellStatus(x,y,color);
    }

    public Colors getCellStatus(int x, int y) {
        return this.board.getCellStatus(1,1);
    }
}
