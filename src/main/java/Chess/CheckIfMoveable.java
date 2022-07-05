package Chess;

public class CheckIfMoveable {

    public boolean checkIfKoodinatesBelongToActivePlayer(String rowOfField, int column, int activePlayer, ChessfieldStatus statusField) {
        int row = convertLetterToInteger(rowOfField);
        String[][] field = statusField.getFieldArray();
        if (activePlayer == 1) {
            return isUpper(field[row][column]);

        } else {
            return !isUpper(field[row][column]);
        }
    }

    public boolean moveCanBeMade(int rowOld, String columnOld, int rowNew, String columnNew, ChessfieldStatus statusField, int activePlayer) {    // Figure can move this way, works if all figures are finished
        WegFrei[][] figuresOnfField = statusField.getWegFreiArray();
        return figuresOnfField[rowOld][convertLetterToInteger(columnOld)].isMoveValidMove(statusField.getFieldArray(), convertLetterToInteger(columnOld), rowOld, rowNew, convertLetterToInteger(columnNew), activePlayer);
    }

    public boolean isUpper(String s) {
        return ((int) s.toCharArray()[0]) < 97;
    }

    public int convertLetterToInteger(String s) { //Uses ASCII Code
        return ((int) (s.toCharArray()[0])) - 65;
    }

}
