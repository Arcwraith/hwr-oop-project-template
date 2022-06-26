package Chess;

public class Pferd implements WegFrei {
    public boolean istZugMoeglichFürPferd(int rowOld, int columnOld, int rowNew, int columnNew, int activePlayer, String fieldWithFigure[][]) {
        if (activePlayer==1 && isMoveValidMove(fieldWithFigure, columnOld,  rowOld,  rowNew,  columnNew) &&
                fieldWithFigure[rowNew][columnNew].equals(" ") || pferdSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure)) {
            return true;}
        else {
            if (activePlayer==2 && isMoveValidMove(fieldWithFigure, columnOld,  rowOld,  rowNew,  columnNew) &&
                    fieldWithFigure[rowNew][columnNew].equals(" ") || pferdSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure)) {
                return true;}
        }
        return false;
    }


    public boolean pferdSchlaegtGegner( int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
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
        if (rowNew == rowOld + 2 && (columnNew == columnOld + 1 || columnNew == columnOld - 1)) {
            return true;
        }
        if (rowNew == rowOld - 2 && (columnNew == columnOld + 1 || columnNew == columnOld - 1)) {
            return true;
        }
        if (columnNew == columnOld + 2 && (rowNew == rowOld + 1 || rowNew == rowOld - 1)) {
            return true;
        }
        if (columnNew == columnOld - 2 && (rowNew == rowOld + 1 || rowNew == rowOld - 1)) {
            return true;
        }
        return false;
    }
}
