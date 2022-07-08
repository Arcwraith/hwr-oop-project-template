package Chess;

public class Koenig implements WegFrei {
    private int player = 0;
    private String bezeichnung = "K";

    public boolean istZugMoeglichFuerKoenig(int rowOld, int columnOld, int rowNew, int columnNew) {
        return ((rowNew == rowOld + 1 && columnNew == columnOld) || (rowNew == rowOld - 1 && columnNew == columnOld) || (columnNew == columnOld + 1 && rowNew == rowOld) || (columnNew == columnOld - 1 && rowNew == rowOld));
    }


    public boolean koenigSchlaegtGegner(int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
        if (fieldWithFigure[rowNew][columnNew].equals(" ")) {
            return false;
        }
        if (activePlayer == 1) {
            if (!checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                return true;
            }
        }
        if (activePlayer == 2) {
            return checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew]);
        }
        return false;
    }

    @Override
    public boolean isMoveValidMove(String[][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer) {
        if ((activePlayer == 1 && istZugMoeglichFuerKoenig(rowOld, columnOld, rowNew, columnNew) && (fieldWithFigure[rowNew][columnNew].equals(" ")) || (koenigSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure)))) {
            return true;
        } else {
            return activePlayer == 2 && istZugMoeglichFuerKoenig(rowOld, rowNew, columnNew, columnOld) && fieldWithFigure[rowNew][columnNew].equals(" ") || koenigSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure);
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