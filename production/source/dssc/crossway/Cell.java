package dssc.crossway;

public class Cell {

    private String status;

    public Cell() {
        this.status = "null";
    }

    Cell (String initialStatus) {
        this.status = initialStatus;
    }


    public String getStatus() {
        return this.status;
    }
}
