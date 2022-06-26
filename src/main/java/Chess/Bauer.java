package Chess;

public class Bauer {

    public boolean istZugMoeglichFürBauer(int rowOld, int columnOld, int rowNew, int columnNew, int activePlayer, ChessfieldStatus statusField, String[][] fieldWithFigure) {
        String[][] field = statusField.getFieldArray();

        if (activePlayer == 1) {
            if ((fieldWithFigure[rowNew][columnNew].equals(" ") && ((rowNew == rowOld +1 && columnNew == columnOld) ||
                    (hasNotMovedJet(rowOld, columnOld, 1, field) && rowNew == rowOld +2 && columnNew == columnOld))) || bauerSchlaegtGegner(rowOld, columnOld, rowNew, columnNew, 1, fieldWithFigure)) {
                return true;
            }
        }
        if (activePlayer == 2) {
            if ((fieldWithFigure[rowNew][columnNew].equals(" ") && ((rowNew == rowOld -1 && columnNew == columnOld) ||
                    (hasNotMovedJet(rowOld, columnOld, 2, field) && rowNew == rowOld -2 && columnNew == columnOld))) || bauerSchlaegtGegner(rowOld, columnOld, rowNew, columnNew, 2, fieldWithFigure)) {
                return true;
            }
        }return false;
    }


    public boolean hasNotMovedJet(int rowOld, int columnOld, int activePlayer, String[][] field) {
        if (activePlayer == 1) {
            for (int i = 0; i < 8; i++) {
                boolean defaultPos = field[rowOld][columnOld].equals(field[1][i]);
                if (defaultPos) {
                    return true;
                }
            }
        }
        if (activePlayer == 2) {
            for (int i = 0; i < 8; i++) {
                boolean defaultPos = field[rowOld][columnOld].equals(field[6][i]);
                if (defaultPos) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bauerSchlaegtGegner(int rowOld, int columnOld, int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
        if(fieldWithFigure[rowNew][columnNew].equals(" ")){return false;}
        if (rowNew == rowOld + 1 && activePlayer == 1) {
            if ((columnNew == columnOld + 1 || columnNew == columnOld - 1) && !checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                return true;
            }
        }
        if (rowNew == rowOld - 1 && activePlayer == 2) {
            if ((columnNew == columnOld + 1 || columnNew == columnOld - 1) && checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                return true;
            }
        }
        return false;
    }
}

