package dssc.crossway;


/**
 * Go board class. A class to manage a Go Board, that is a square check board.
 *
 */
public class GoBoard extends GenericBoard {

    /**
     * GoBoard constructor
     * @param side the side of the board, in cells
     */
    public GoBoard(int side) {
        super(side);
        initializeBoard();
    }

    /**
     * board initialization
     */
    @Override
    public void initializeBoard() {
        for (int i=0; i<this.side; i++) {
            for (int j=0; j<this.side; j++) {
                this.board[i][j] = new Cell(Colors.EMPTY);
            }
        }
    }


    /**
     * Side getter
     * @return the side of the board in cells
     */
    public int getSide() {

        return side;
    }

    /** Cell getter
     * @return Gets the String status of a cell
     */
    public Colors getCellStatus(int x, int y) throws OutOfBoardException {

        if ((x>=this.side)||(y>=this.side)) {
            throw new OutOfBoardException();
        }

        return this.board[x][y].getStatus();
    }

    /**
     * Cell setter
     * @param x x board coordinates
     * @param y y board coordinates
     * @param newStatus String status to update
     */
    public void setCellStatus(int x, int y, Colors newStatus) throws OutOfBoardException {

        if ((x>=this.side)||(y>=this.side)) {
            throw new OutOfBoardException();
        }

        this.board[x][y].setStatus(newStatus);


    }
}
