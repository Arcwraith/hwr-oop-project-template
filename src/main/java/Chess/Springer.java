package Chess;

public class Springer implements WegFrei {
    private int player = 0;

    public boolean istZugMoeglichFuerSpringer(int rowOld, int columnOld, int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        if (activePlayer == 1 && isMoveValidMove(fieldWithFigure, columnOld, rowOld, rowNew, columnNew, 1) && fieldWithFigure[rowNew][columnNew].equals(" ") || springerSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure)) {
            return true;
        } else {
            return activePlayer == 2 && isMoveValidMove(fieldWithFigure, columnOld, rowOld, rowNew, columnNew, 2) && fieldWithFigure[rowNew][columnNew].equals(" ") || springerSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure);
        }
    }


    public boolean springerSchlaegtGegner(int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
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
        if (activePlayer == 2) {
            //sind kleine Buchstaben
            return checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew]);
        }
        return false;
    }

    @Override
    public boolean isMoveValidMove(String[][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer) {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < i - 1; j++) {
                if (columnNew == columnOld + i && rowNew == rowOld + i && fieldWithFigure[rowOld + j][columnOld + j].equals(" ")) {
                    return true;//ist i bei columnOld und rowOld gleich?
                }
            }
        }
        return false;
    }

    @Override
    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public int getPlayer() {
        return this.player;
    }

}