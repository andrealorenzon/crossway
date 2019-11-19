package dssc.crossway;

 abstract class Validator {

     Validator() {
    }

     public abstract boolean validateMove(GoBoard board, Move m0);
 }
