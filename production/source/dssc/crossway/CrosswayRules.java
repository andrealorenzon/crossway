package dssc.crossway;

public class CrosswayRules extends Validator {

    public CrosswayRules() {

    }

    private boolean noSuperposition(GoBoard board, Move m) throws OutOfBoardException {
        return board.getCellStatus(m.getX(), m.getY()) == Colors.EMPTY;
    }

    private boolean noCrossways(GoBoard board, Move m) throws OutOfBoardException {

        Colors enemy = m.getColor().getOpposite();
        Colors friendly = m.getColor();
        boolean legality = true;
        GoBoard window = new GoBoard(2);

        //case 1: the move cell is SouthEast
        try {
            window.setCellStatus(0,0, board.getCellStatus(m.getX()-1, m.getY()-1));
            window.setCellStatus(1,0, board.getCellStatus(m.getX(),      m.getY()-1));
            window.setCellStatus(0,1, board.getCellStatus(m.getX()-1,    m.getY())  );
        } catch (OutOfBoardException ignored) {}

        if ( window.getCellStatus(0,0) == friendly &&
            window.getCellStatus(1,0) == enemy &&
            window.getCellStatus(0,1) == enemy)  {legality = false;}

        //case 2: the move cell is SouthWest
        try {
            window.setCellStatus(0,0, board.getCellStatus(m.getX(), m.getY()-1));
            window.setCellStatus(1,0, board.getCellStatus(m.getX()+1,      m.getY()-1));
            window.setCellStatus(1,1, board.getCellStatus(m.getX()+1,    m.getY())  );
        } catch (OutOfBoardException ignored) {}

        if ( window.getCellStatus(1,0) == friendly &&
                window.getCellStatus(0,0) == enemy &&
                window.getCellStatus(1,1) == enemy)  {legality = false;}

        //case 3: the move cell is NorthWest
        try {
            window.setCellStatus(0,1, board.getCellStatus(m.getX(), m.getY()+1));
            window.setCellStatus(1,1, board.getCellStatus(m.getX()+1,      m.getY()+1));
            window.setCellStatus(1,0, board.getCellStatus(m.getX()+1,    m.getY()));
        } catch (OutOfBoardException ignored) {}

        if ( window.getCellStatus(1,1) == friendly &&
                window.getCellStatus(1,0) == enemy &&
                window.getCellStatus(0,1) == enemy)  {legality = false;}

        //case 4: the move cell is NorthEast
        try {
            window.setCellStatus(0,0, board.getCellStatus(m.getX()-1,         m.getY()));
            window.setCellStatus(0,1, board.getCellStatus(m.getX()-1,      m.getY()+1));
            window.setCellStatus(1,1, board.getCellStatus(m.getX(),           m.getY()+1));
        } catch (OutOfBoardException ignored) {}

        if ( window.getCellStatus(0,1) == friendly &&
                window.getCellStatus(0,0) == enemy &&
                window.getCellStatus(1,1) == enemy)  {legality = false;}



        return legality;
    }

    @Override
    public boolean validateMove(GoBoard board, Move m) throws OutOfBoardException {
        //check rule 1
        return noSuperposition(board, m) &&
                noCrossways(board,m);

    }

    @Override

    public Colors winner(GoBoard board) throws  OutOfBoardException{


        for(int i = 0; i < board.getSide(); i++ ){
            // Check white
            if(board.getCellStatus(0,i) == Colors.WHITE){
                if(winningChain(0, i,Colors.WHITE))
                    return Colors.WHITE;
            }
            //Check black
            if(board.getCellStatus(i,0) == Colors.BLACK){
                if(winningChain(i, 0,Colors.BLACK))
                    return Colors.BLACK;
            }
        }

        return Colors.EMPTY;

    }

    private boolean winningChain(int x, int y, Colors c) {





        return true ;
    }

}
