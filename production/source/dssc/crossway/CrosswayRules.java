package dssc.crossway;

public class CrosswayRules extends Validator {

    public CrosswayRules() {

    }

    private boolean noSuperposition(GoBoard board, Move m)  {
        return board.getCellStatus(m.getX(), m.getY()) == Colors.EMPTY;
    }

    @Override
    public boolean validateMove(GoBoard board, Move m) {
        //check rule 1
        return noSuperposition(board, m);

    }
}
