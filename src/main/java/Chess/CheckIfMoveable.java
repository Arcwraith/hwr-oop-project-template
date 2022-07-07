package Chess;

public class CheckIfMoveable {

    public boolean checkIfKoodinatesBelongToActivePlayer(String column, int row, int activePlayer, ChessfieldStatus statusField) {
        //WegFrei[][] figures = statusField.getWegFreiArray();
        String[][] figuress = statusField.getFieldArray();
        if (activePlayer == 1) {
            return (isUpper(figuress[row][convertLetterToInteger(column)]));

        } else {
            return !(isUpper(figuress[row][convertLetterToInteger(column)]));
        }
    }

    public boolean moveCanBeMade(int rowOld, String columnOld, int rowNew, String columnNew, ChessfieldStatus statusField, int activePlayer) {
        WegFrei[][] figuresOnfField = statusField.getWegFreiArray();
        return figuresOnfField[rowOld][convertLetterToInteger(columnOld)].isMoveValidMove(statusField.getFieldArray(), convertLetterToInteger(columnOld), rowOld, rowNew, convertLetterToInteger(columnNew), activePlayer);
    }

    public boolean isUpper(String s) {
        return ((int) s.toCharArray()[0]) < 97;
    }

    public int convertLetterToInteger(String s) { //Uses ASCII Code
        return ((int) (s.toCharArray()[0])) - 65;
    }

    public boolean belongsToPlayerOne(WegFrei figure) {    //Is white
        return (1 == figure.getPlayer());
    }
}
