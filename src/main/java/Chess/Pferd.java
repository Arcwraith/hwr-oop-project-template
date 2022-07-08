package Chess;

public class Pferd implements WegFrei {
    private int player = 0;
    private String bezeichnung = "S";

    public boolean istZugMoeglichFuerPferd(int rowOld, int columnOld, int rowNew, int columnNew) {
        if (rowNew == rowOld + 2 && (columnNew == columnOld + 1 || columnNew == columnOld - 1)) {
            return true;
        }
        if (rowNew == rowOld - 2 && (columnNew == columnOld + 1 || columnNew == columnOld - 1)) {
            return true;
        }
        if (columnNew == columnOld + 2 && (rowNew == rowOld + 1 || rowNew == rowOld - 1)) {
            return true;
        }
        return columnNew == columnOld - 2 && (rowNew == rowOld + 1 || rowNew == rowOld - 1);
    }


    public boolean pferdSchlaegtGegner(int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
        if (fieldWithFigure[rowNew][columnNew].equals(" ")) {
            return false;
        }
        if (activePlayer == 1) {
            if (!checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                //sind gr0ße Buchstaben
                return true;
            }
        }
        if (activePlayer == 2){
            return checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew]);
        }
        return false;
    }

    @Override
    public boolean isMoveValidMove(String[][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer) {
        if (activePlayer == 1 && istZugMoeglichFuerPferd(rowOld, columnOld, rowNew, columnNew) && fieldWithFigure[rowNew][columnNew].equals(" ") || pferdSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure)) {
            return true;
        } else {
            return activePlayer == 2 && istZugMoeglichFuerPferd(rowOld, columnOld, rowNew, columnNew) && fieldWithFigure[rowNew][columnNew].equals(" ") || pferdSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure);
        }
    }

    @Override
    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public int getPlayer() {
        return this.player;
    }

    @Override
    public String getBezeichnung() {
        return bezeichnung;
    }
}
