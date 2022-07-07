package Chess;

public class Main {

    public static void main(String[] args) {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        field.displayFieldWithFigures();
        field.fullfillMoveAndNextPlayersTurn(statusField);

        while (field.gameNotOver()) {
            field.fullfillMoveAndNextPlayersTurn(statusField);
        }
    }
}
