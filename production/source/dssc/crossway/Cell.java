package dssc.crossway;

/**
 * A Cell class.
 *
 * Default status = "null"
 */
public class Cell {

    private CellStatus status;

    public Cell() {
        this.status = CellStatus.EMPTY;
    }

    //ctor
    Cell (CellStatus status) {
        this.status = status;
    }


    public CellStatus getStatus() {
        return this.status;
    }

    void setStatus(CellStatus newStatus) {
        this.status = newStatus;
    }
}
