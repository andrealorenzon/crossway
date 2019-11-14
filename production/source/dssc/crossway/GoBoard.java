package dssc.crossway;


/**
 * Go board class. A class to manage a Go Board, that is a square check board.
 *
 */
public class GoBoard {

    private final Integer side;
    private Cell[][] board;

    /**
     * GoBoard Constructor.
     * @param side the side of the board in units
     */
    public GoBoard(Integer side) {

        this.side = side;
        this.board = new Cell [side][side];

        for (int i=0; i<this.side; i++) {
            for (int j=0; j<this.side; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

    /**
     * Side getter
     * @return the side of the board in cells
     */
    public Integer getSide() {

        return side;
    }

    /** Cell getter
     * @return Gets the String status of a cell
     */
    public String getCellStatus(int x, int y) {

        return this.board[x][y].getStatus();
    }

    /**
     * Cell setter
     * @param x x board coordinates
     * @param y y board coordinates
     * @param newStatus String status to update
     */
    public void setCellStatus(int x, int y, String newStatus) throws OutOfBoardException {

        if ((x>=this.side)||(y>=this.side)) {
            throw new  OutOfBoardException();
        }

        this.board[x][y].setStatus(newStatus);


    }
}
