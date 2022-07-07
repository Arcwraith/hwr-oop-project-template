package Chess;

public class Dame implements WegFrei {
    private int player = 0;

    public boolean istZugMoeglichFuerDame(int rowOld, int columnOld, int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {

        if (activePlayer == 1 && isMoveValidMove(fieldWithFigure, columnOld, rowOld, rowNew, columnNew, 1) && fieldWithFigure[rowNew][columnNew].equals(" ") || dameSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure)) {
            return true;
        } else {
            return activePlayer == 2 && isMoveValidMove(fieldWithFigure, columnOld, rowOld, rowNew, columnNew, 2) && fieldWithFigure[rowNew][columnNew].equals(" ") || dameSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure);
        }
    }


    public boolean dameSchlaegtGegner(int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
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
        for (int i = 1; i < 8; i++) {
            for (int j = columnOld + 1; j < columnNew; j++) {
                if (columnNew == columnOld + i && rowNew == rowOld && fieldWithFigure[rowNew][j].equals(" ")) {
                    return true;
                }
            }
            for (int j = columnOld - 1; j > columnNew; j--) {
                if (columnNew == columnOld - i && rowNew == rowOld && fieldWithFigure[rowNew][j].equals(" ")) {
                    return true;
                }
            }
            for (int j = rowOld + 1; j < rowNew; j++) {
                if (columnNew == columnOld && rowNew == rowOld + i && fieldWithFigure[j][columnNew].equals(" ")) {
                    return true;
                }
            }
            for (int j = rowOld - 1; j > rowNew; j--) {
                if (columnNew == columnOld && rowNew == rowOld - i && fieldWithFigure[j][columnNew].equals(" ")) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public int getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(int player) {
        this.player = player;
    }
}