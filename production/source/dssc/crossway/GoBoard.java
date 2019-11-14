package dssc.crossway;


/**
 * Go board class. A class to manage a Go Board, that is a square check board.
 *
 *  @param side : the side, in cells, of the square board
 */
public class GoBoard {

    private final Integer side;

    /**
     * GoBoard Constructor.
     * @param side
     */
    public GoBoard(Integer side) {
        this.side = side;
    }

    /**
     * Side getter
     * @return the side of the board in cells
     */
    public Integer getSide() {
        return side;
    }

    /** Cell getter
     * @return Gets the status of a cell (-1= null, 0=black, 1=white)
     */
    public short getCellStatus(int x, int y) {
        return 0;
    }


}
