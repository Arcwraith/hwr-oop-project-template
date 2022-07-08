package Chess;

public class Bauer implements WegFrei {
    private int player = 0;
    private String bezeichnung = "B";

    @Override
    public boolean isMoveValidMove(String[][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer) {
        if (activePlayer == 1) {
            if (((fieldWithFigure[rowNew][columnNew].equals(" ") && (rowNew == rowOld + 1 && columnNew == columnOld)) || (hasNotMovedJet(rowOld, columnOld, 1, fieldWithFigure) && rowNew == rowOld + 2 && columnNew == columnOld)) || (bauerSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure))) {
                return true;
            }
        }
        if (activePlayer == 2) {
            return (fieldWithFigure[rowNew][columnNew].equals(" ") && ((rowNew == rowOld - 1 && columnNew == columnOld)) || (hasNotMovedJet(rowOld, columnOld, 2, fieldWithFigure) && rowNew == rowOld - 2 && columnNew == columnOld)) || (bauerSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure));
        }
        return false;
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

    public boolean bauerSchlaegtGegner(int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
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
    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public String getBezeichnung() {
        return bezeichnung;
    }

    @Override
    public int getPlayer() {
        return this.player;
    }
}

