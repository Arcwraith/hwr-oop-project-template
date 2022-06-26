package Chess;

public class Springer implements WegFrei {
    public boolean istZugMoeglichFürSpringer(int rowOld, int columnOld, int rowNew, int columnNew, int activePlayer, String fieldWithFigure[][]) {
        if (activePlayer==1 && isMoveValidMove(fieldWithFigure, columnOld,  rowOld,  rowNew,  columnNew) &&
                fieldWithFigure[rowNew][columnNew].equals(" ") || springerSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure)) {
            return true;}
        else {
            if (activePlayer==2 && isMoveValidMove(fieldWithFigure, columnOld,  rowOld,  rowNew,  columnNew) &&
                    fieldWithFigure[rowNew][columnNew].equals(" ") || springerSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure)) {
                return true;}
        }
        return false;
    }


    public boolean springerSchlaegtGegner( int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
        if (fieldWithFigure[rowNew][columnNew].equals(" ")) {return false;}
        if (activePlayer == 1) {
            if (!checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                //sind gr0ße Buchstaben
                return true;
            }
        }
        if (activePlayer == 2) {
            if (checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                //sind kleine Buchstaben
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isMoveValidMove(String [][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew) {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < i - 1; j++) {
                if (columnNew == columnOld + i && rowNew == rowOld + i && fieldWithFigure[rowOld + j][columnOld + j].equals(" ")) {
                    return true;//ist i bei columnOld und rowOld gleich?
                }
            }
        }
        return false;
    }

}