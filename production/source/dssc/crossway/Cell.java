package dssc.crossway;

/**
 * A Cell class.
 *
 * Default status = "null"
 */
public class Cell {

    private String status;

    public Cell() {
        this.status = "null";
    }

    //ctor
    Cell (String initialStatus) {
        this.status = initialStatus;
    }


    public String getStatus() {
        return this.status;
    }

    void setStatus(String newStatus) {
        this.status = newStatus;
    }
}
