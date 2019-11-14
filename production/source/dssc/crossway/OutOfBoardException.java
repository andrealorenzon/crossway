package dssc.crossway;

public class OutOfBoardException extends Exception {

    @Override
    public String getMessage() {
        return ("Out of board!");
    }
}
