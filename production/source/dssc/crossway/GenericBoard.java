package dssc.crossway;

public abstract class GenericBoard {

    protected Integer side;
    protected Cell [][] board;

    /**
     * GoBoard Constructor. Initializes a matrix of Cell items
     * @param side the side of the board in units
     */
     protected GenericBoard (Integer side) {

        this.side = side;
        this.board = new Cell [side][side];

    }

    abstract void initializeBoard(CellStatus initialValue);
}
